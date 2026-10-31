import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[][] scoresBoard = new int[scores.length][4];
        boolean[] incentive = new boolean[scores.length];
        for (int i = 0; i < scores.length; i++) {
            scoresBoard[i] = new int[]{scores[i][0], scores[i][1], i, (scores[i][0] + scores[i][1])};
        }
        
        Arrays.sort(scoresBoard, (o1, o2) -> {
            if (o1[0] != o2[0]) return o2[0] - o1[0]; // A 내림차순
            return o1[1] - o2[1];                      // B 오름차순
        });
        
        int maxB = 0;
        for (int i = 0; i < scoresBoard.length; i++) {
            if (scoresBoard[i][1] < maxB) {
                incentive[i] = true;
            } else {
                maxB = scoresBoard[i][1];
            }
        }
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < incentive.length; i++) {
            if (!incentive[i]) {
                list.add(scoresBoard[i]);
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1[3] != o2[3]) {
                return o2[3] - o1[3];
            } else {
                return o1[2] - o2[2];
            }
        });
        
        int answer = 0;
        int count = 1;
        boolean flag = false;
        for (int[] now : list) {
            if (now[2] != 0) {
                count++;
                continue;
            } else {
                answer = count;
                flag = true;
                break;
            }
        }
        
        if (flag) {
            return answer;
        } else {
            return -1;
        }
        
    }
}