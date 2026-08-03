import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (idx % 3 == 0) {
                    x++;
                }
                if (idx % 3 == 1) {
                    y++;
                }
                if (idx % 3 == 2) {
                    x--;
                    y--;
                }
                board[x][y] = num;
                num++;
            }
            idx++;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    list.add(board[i][j]);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}