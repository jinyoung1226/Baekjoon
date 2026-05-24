import java.util.*;

class Solution {
    int[][] board;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int answer = 0;
    
    class Point {
        int x;
        int y;
        int dist;
        
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        board = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                board[i][j] = maps[i][j];
            }
        }
        
        if(bfs()) {
            return answer;
        } else {
            return -1;
        }
    }
    
    public boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if (now.x == board.length-1 && now.y == board[0].length-1) {
                answer = now.dist;
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                
                if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length) {
                    if (!visited[newX][newY] && board[newX][newY] != 0) {
                        visited[newX][newY] = true;
                        q.add(new Point(newX, newY, now.dist + 1));
                    }
                }
            }
        }
        return false;
    }
}