import java.util.*;

class Solution {
    boolean[][] visited;
    class Point {
        int x;
        int y;
        int real_x;
        int real_y;
        
        public Point(int x, int y, int real_x, int real_y) {
            this.x = x;
            this.y = y;
            this.real_x = real_x;
            this.real_y = real_y;
        }
    }
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    int result = Integer.MIN_VALUE;
    
    public int solution(int[] mats, String[][] park) {
        for (int i = 0; i < mats.length; i++) {
            int size = mats[i];
            visited = new boolean[park.length][park[0].length];
            for (int j = 0; j < park.length; j++) {
                for (int k = 0; k < park[0].length; k++) {
                    if (park[j][k].equals("-1")) {
                        if (BFS(j, k, size, park)) {
                            result = Math.max(result, size);
                        } else {
                            visited = new boolean[park.length][park[0].length];
                        }
                    }
                }
            }
        }
        if (result == Integer.MIN_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
    
    public boolean BFS(int x, int y, int size, String[][] park) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, x, y));
        visited[x][y] = true;
        int compare_size = 0;
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            compare_size++;
            
            for (int i = 0; i < 2; i++) {
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                int next_real_x = now.real_x + dx[i];
                int next_real_y = now.real_y + dy[i];
                if (next_real_x < park.length && next_real_y < park[0].length && next_x < size && next_y < size) {
                    if (park[next_real_x][next_real_y].equals("-1") && !visited[next_real_x][next_real_y]) {
                        visited[next_real_x][next_real_y] = true;
                        q.add(new Point(next_x, next_y, next_real_x, next_real_y));
                    }
                }
            }
        }
        
        return (size*size) == compare_size ? true : false;
    }
}