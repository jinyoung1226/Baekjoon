import java.util.*;

class Solution {
    
    static class Point {
        int x;
        int y;
        int dist;
        
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        
        int result = bfs(maps);
        return result;
        
    }
    
    static int bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            
            if (now.x == maps.length - 1 && now.y == maps[0].length - 1) {
                return now.dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] != 0) {
                        visited[nextX][nextY] = true;
                        q.add(new Point(nextX, nextY, now.dist + 1));
                    }
                }
            }
        }
        
        return -1;
    }
}