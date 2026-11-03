import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // 0, 90, 180, 270도 회전했을 때의 board와 그 board에서 열쇠가 있는 (x,y)만 추출
        List<int[]> keyArr0 = new ArrayList<>();
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                if (key[i][j] == 1) {
                    keyArr0.add(new int[]{i, j});
                }
            }
        }
        
        int M = key.length;
        int N = lock.length;
        
        List<int[]> keyArr90 = rotate(key, 90);
        List<int[]> keyArr180 = rotate(key, 180);
        List<int[]> keyArr270 = rotate(key, 270);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[0].length; j++) {
                if (lock[i][j] == 0) {
                    set.add(i + "," + j);
                }
            }
        }
        
        
        boolean answer = false;
        for (int i = -M + 1; i < N; i++) {
            if (answer) break;
            for (int j = -M + 1; j < N; j++) {
                
                for (int k = 0; k < 4; k++) {
                    List<int[]> currentKey = null;
                    if (k == 0) currentKey = keyArr0;
                    else if (k == 1) currentKey = keyArr90;
                    else if (k == 2) currentKey = keyArr180;
                    else currentKey = keyArr270;
                    
                    HashSet<String> setK = new HashSet<>();
                    boolean isInvalid = false;
                    
                    for (int l = 0; l < currentKey.size(); l++) {
                        int r = currentKey.get(l)[0] + i;
                        int c = currentKey.get(l)[1] + j;
                        
                        // 자물쇠 영역 안의 좌표일 때만 판정
                        if (r >= 0 && r < N && c >= 0 && c < N) {
                            // 3. 자물쇠 돌기(1)와 열쇠 돌기(1)가 충돌하는 경우 예외 처리
                            if (lock[r][c] == 1) {
                                isInvalid = true;
                                break;
                            }
                            setK.add(r + "," + c);
                        }
                    }
                    
                    // 돌기 충돌이 없었고, 자물쇠의 모든 홈(0)을 채웠다면 정답
                    if (!isInvalid && setK.containsAll(set)) {
                        answer = true;
                        break;
                    }
                }
                if (answer) break;
            }
        }
        
        
        
        
        return answer;
    }
    
    public List<int[]> rotate(int[][] key, int rotate) {
        int[][] copyBoard = new int[key.length][key[0].length];
        
        if (rotate == 90) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[0].length; j++) {
                    copyBoard[j][(key.length-1) - i] = key[i][j];
                }
            }
        } else if (rotate == 180) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[0].length; j++) {
                    copyBoard[(key.length-1) - i][(key.length - 1) - j] = key[i][j];
                }
            }
        } else {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[0].length; j++) {
                    copyBoard[(key.length-1) - j][i] = key[i][j];
                }
            }
        }
        
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < copyBoard.length; i++) {
            for (int j = 0; j < copyBoard[0].length; j++) {
                if (copyBoard[i][j] == 1) {
                    result.add(new int[]{i,j});
                }
            }
        }
        
        return result;
    }
} 