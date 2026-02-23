import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (computers[i][j] == 1) {
                    list.add(new int[]{i,j});
                }
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            int[] data = list.get(i);
            union(data[0], data[1]);
        }
        
        System.out.println(Arrays.toString(parent));
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(find(i));
        }
        
        
        return set.size();
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);
        
        if (nx < ny) parent[ny] = nx;
        else parent[nx] = ny;
    }
}