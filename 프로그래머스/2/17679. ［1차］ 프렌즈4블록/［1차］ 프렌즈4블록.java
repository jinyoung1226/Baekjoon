import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int result = 0;
        char[][] gameBoard = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            int count = 0;
            boolean[][] visited = new boolean[m][n];
            
            for (int i = 0; i < gameBoard.length - 1; i++) {
                for (int j = 0; j < gameBoard[0].length - 1; j++) {
                    if (gameBoard[i][j] != '0') {
                        if (gameBoard[i][j] == gameBoard[i][j+1] && gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i+1][j+1]) {
                            visited[i][j] = true;
                            visited[i][j+1] = true;
                            visited[i+1][j] = true;
                            visited[i+1][j+1] = true;
                        } 
                    }
                }
            }
            
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    if (visited[i][j] == true) {
                        count++;
                        gameBoard[i][j] = '0';
                    }
                }
            }
            
            if (count == 0) break;
            
            List<String> list = new ArrayList<>();
            
            for (int j = 0; j < gameBoard[0].length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < gameBoard.length; i++) {
                    if (gameBoard[i][j] != '0') {
                        sb.append(gameBoard[i][j]);
                    }
                }
                if (sb.toString().equals("")) {
                    list.add("");
                } else {
                    list.add(sb.toString());
                }
            }
            
            for (int j = 0; j < gameBoard[0].length; j++) {
                int temp = m - list.get(j).length();
                int idx = 0;
                for (int i = 0; i < gameBoard.length; i++) {
                    if (i < temp) {
                        gameBoard[i][j] = '0';
                    } else {
                        gameBoard[i][j] = list.get(j).charAt(idx);
                        idx++;
                    }
                }
            }
            
            result += count;
        }

        return result;
    }
}