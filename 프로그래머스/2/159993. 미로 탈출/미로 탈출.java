import java.util.*;

class Solution {
    String[][] board;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        board = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lavor = new int[2];
        int[] end   = new int[2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                board[i][j] = String.valueOf(maps[i].charAt(j));
                if (board[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
                if (board[i][j].equals("L")) {
                    lavor[0] = i;
                    lavor[1] = j;
                }
                if (board[i][j].equals("E")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int result = 0;
        int firstTime = bfs(start, lavor);
        if (firstTime == -1) {
            return -1;
        } else {
            result += firstTime;
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        int secondTime = bfs(lavor, end);
        if (secondTime == -1) {
            return -1;
        } else {
            result += secondTime;
        }
        
        return result;
    }
    
    public int bfs(int[] from, int[] to) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{from[0], from[1], 0});
        visited[from[0]][from[1]] = true;
        int result = -1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == to[0] && now[1] == to[1]) {
                result = now[2];
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length) {
                    if (!visited[nextX][nextY] && !board[nextX][nextY].equals("X")) {
                        q.add(new int[]{nextX, nextY, now[2] + 1});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        
        
        return result;
    }
}