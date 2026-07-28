import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n+1];
        for (int i = 1; i < parent.length; i++) parent[i] = i;
        Arrays.sort(costs, (a,b) -> a[2] - b[2]); 
        
        for (int i = 0; i < costs.length; i++) {
            int node1 = costs[i][0];
            int node2 = costs[i][1];
            int cost = costs[i][2];
            
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
                answer += cost;
            }
        }

        return answer;
    }
    
    public int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
    
    public boolean union(int[] parent, int x, int y) {
        int nx = find(parent, x);
        int ny = find(parent, y);
        
        if (nx == ny) return false;
        parent[ny] = nx;
        return true;
    }
    
    
}