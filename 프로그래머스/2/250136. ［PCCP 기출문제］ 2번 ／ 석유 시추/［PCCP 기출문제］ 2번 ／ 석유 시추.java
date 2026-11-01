import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    int[] result;
    public int solution(int[][] land) {
        result = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        for (int c = 0; c < land[0].length; c++) {
            for (int l = 0; l < land.length; l++) {
                if (!visited[l][c] && land[l][c] == 1) {
                    bfs(land, l, c);
                }
            }
        }
        Arrays.sort(result);
        return result[result.length - 1];
    }
    
    void bfs(int[][] land, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int maxOilCount = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(y);
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        set.add(ny);
                        maxOilCount++;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        for (Integer col : set) {
            result[col] += maxOilCount;
        }

    }
}