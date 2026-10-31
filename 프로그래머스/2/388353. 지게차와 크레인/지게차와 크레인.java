import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(String[] storage, String[] requests) {
        char[][] board = new char[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {
                board[i][j] = storage[i].charAt(j);
            }
        }
        
        for (String request : requests) {
            char req = request.charAt(0);
            if (request.length() == 1) {
                removeCar(board, req);
            } else {
                removeCrain(board, req);
            }
        }
        
        System.out.println(Arrays.deepToString(board));
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '0') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    void removeCrain(char[][] board, char req) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == req) {
                    board[i][j] = '0';
                }
            }
        }
    }
    
    void removeCar(char[][] board, char req) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length -1 ) {
                    if (!visited[i][j]) {
                        dfs(board, visited, i, j, req);
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = '0';
                }
            }
        }
    }
    
    void dfs(char[][] board, boolean[][] visited, int x, int y, char req) {
        if (board[x][y] == req) {
            visited[x][y] = true;
            board[x][y] = '1';
            return;
        }
        
        if (board[x][y] != '0') {
            return;
        }
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !visited[nx][ny]) {
                if (board[nx][ny] == '0' || board[nx][ny] == req) {
                    dfs(board, visited, nx, ny, req);
                }
            }
        }
    }
}