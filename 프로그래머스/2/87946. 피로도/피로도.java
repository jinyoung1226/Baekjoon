import java.util.*;

class Solution {
    int result = Integer.MIN_VALUE;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        
        

        return result;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        result = Math.max(result, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
    }
}