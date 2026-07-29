import java.util.*;

class Solution {
    class Point {
        int x;
        int y;
        int cost;
        String str;
        
        public Point(int x, int y, int cost, String str) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.str = str;
        }
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    String[][] miro;
    boolean[][] visited;
    public int solution(String[] maps) {
        miro = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] levor = new int[2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                
                if (maps[i].charAt(j) == 'L') {
                    levor[0] = i;
                    levor[1] = j;
                }
                miro[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        
        int levor_cost = bfs_levor(start);
        if (levor_cost == -1) {
            return -1;
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        
        int exit_cost = bfs_exit(levor);
        if (exit_cost == -1) {
            return -1;
        }
        
        return levor_cost + exit_cost;
    }
    
    public int bfs_levor(int[] start) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start[0], start[1], 0, "S"));
        visited[start[0]][start[1]] = true;
        int result = -1;
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            
            if (now.str.equals("L")) {
                result = now.cost;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < miro.length && nextY < miro[0].length) {
                    if (!miro[nextX][nextY].equals("X") && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.add(new Point(nextX, nextY, now.cost + 1, miro[nextX][nextY]));
                    }
                }
            }
        }
        
        return result;
    }
    
    public int bfs_exit(int[] start) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start[0], start[1], 0, "S"));
        visited[start[0]][start[1]] = true;
        int result = -1;
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            
            if (now.str.equals("E")) {
                result = now.cost;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < miro.length && nextY < miro[0].length) {
                    if (!miro[nextX][nextY].equals("X") && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.add(new Point(nextX, nextY, now.cost + 1, miro[nextX][nextY]));
                    }
                }
            }
        }
        
        return result;
    }
}