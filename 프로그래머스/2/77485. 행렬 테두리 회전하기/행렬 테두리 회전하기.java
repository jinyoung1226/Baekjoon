import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int increase = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = increase++;
            }
        }
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int one = queries[i][0]-1;
            int two = queries[i][1]-1;
            int three = queries[i][2]-1;
            int four = queries[i][3]-1;
            Deque<Integer> dq = new ArrayDeque<>();
            Integer min = Integer.MAX_VALUE;
            
            for (int j = two; j <= four; j++) {
                dq.addLast(board[one][j]);
            }
            
            for (int j = one; j <= three; j++) {
                if (j == one) continue;
                dq.addLast(board[j][four]);
            }
            
            for (int j = four; j >= two; j--) {
                if (j == four) continue;
                dq.addLast(board[three][j]);
            }
            
            for (int j = three; j >= one; j--) {
                if (j == three) continue;
                if (j == one) continue;
                dq.addLast(board[j][two]);
            }
            dq.addFirst(dq.pollLast());
            
            for (int j = two; j <= four; j++) {
                int insert = dq.pollFirst();
                min = Math.min(min, insert);
                board[one][j] = insert;
            }
            
            for (int j = one; j <= three; j++) {
                if (j == one) continue;
                int insert = dq.pollFirst();
                min = Math.min(min, insert);
                board[j][four] = insert;
            }
            
            for (int j = four; j >= two; j--) {
                if (j == four) continue;
                int insert = dq.pollFirst();
                min = Math.min(min, insert);
                board[three][j] = insert;
            }
            
            for (int j = three; j >= one; j--) {
                if (j == three) continue;
                if (j == one) continue;
                int insert = dq.pollFirst();
                min = Math.min(min, insert);
                board[j][two] = insert;
            }
            result[i] = min;
        }
        
        return result;
    }
}