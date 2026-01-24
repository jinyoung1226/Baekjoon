import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        comb(k, dungeons, 0);
        return result;
        
    }
    
    static void comb(int k, int[][] dungeons, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]) {
                    visited[i] = true;
                    count++;
                    result = Math.max(result, count);
                    k -= dungeons[i][1];
                    comb(k, dungeons, count);
                    visited[i] = false;
                    count--;
                    k += dungeons[i][1];
                }
            }
        }
    }
}