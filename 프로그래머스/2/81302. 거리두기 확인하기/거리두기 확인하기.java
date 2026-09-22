import java.util.*;
class Solution {
    // 상 하 좌 우
    int[] one_dx_x = {-1, 1, 0, 0}; 
    int[] one_dx_y = {0, 0, 1, -1};
    // 왼위, 오위, 오아래, 왼아래
    int[] two_dx_x = {-1, -1, 1, 1};
    int[] two_dx_y = {-1, 1, 1, -1};
    int[][] two_idx_x = {
        {0, -1},
        {-1, 0},
        {0, 1},
        {1, 0},
    };
    int[][] two_idx_y = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1},
    };
    // 상상 하하 좌좌 우우
    int[] three_dx_x = {-2, 2, 0, 0};
    int[] three_dx_y = {0, 0, 2, -2};
    int[] three_idx_x = {-1, 1, 0, 0};
    int[] three_idx_y = {0, 0, 1, -1};
    
    int[] result = new int[5];
    public int[] solution(String[][] places) {
        for (int i = 0; i < 5; i++) {
            String[][] table = new String[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    table[j][k] = String.valueOf(places[i][j].charAt(k));
                }
            }
            System.out.println(Arrays.deepToString(table));
            
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (table[j][k].equals("P")) {
                        if (!search(table, j, k)) {
                            flag = false;
                        }
                    }
                }
            }
            
            if (flag) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
    
    public boolean search(String[][] table, int x, int y) {
        // 1단계 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = x + one_dx_x[i];
            int nextY = y + one_dx_y[i];
            
            if (nextX >= 0 && nextY >= 0 && nextX <= 4 && nextY <= 4) {
                if (table[nextX][nextY].equals("P")) {
                    return false;
                }
            }
        }
        
        // 2단계 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = x + two_dx_x[i];
            int nextY = y + two_dx_y[i];
            
            if (nextX >= 0 && nextY >= 0 && nextX <= 4 && nextY <= 4) {
                if (table[nextX][nextY].equals("P")) {
                    if (!table[x + two_idx_x[i][0]][y + two_idx_y[i][0]].equals("X") || !table[x + two_idx_x[i][1]][y + two_idx_y[i][1]].equals("X")) {
                        return false;
                    }
                }
            }
        }
        
        // 3단계 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = x + three_dx_x[i];
            int nextY = y + three_dx_y[i];
            
            if (nextX >= 0 && nextY >= 0 && nextX <= 4 && nextY <= 4) {
                if (table[nextX][nextY].equals("P")) {
                    if (!table[x + three_idx_x[i]][y + three_idx_y[i]].equals("X")) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}