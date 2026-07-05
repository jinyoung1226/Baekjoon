import java.util.*;

class Solution {
    boolean[] visited = new boolean[1000001];
    
    public int solution(int x, int y, int n) {
        int result = bfs(x,y,n);
        return result;
    }
    
    public int bfs(int start, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int oper_count = now[1];
            
            if (node == y) {
                return oper_count;
            }
            
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int next_node = node + n;
                    if (next_node <= y && !visited[next_node]) {
                        visited[next_node] = true;
                        q.add(new int[]{next_node, oper_count+1});
                    }
                } else if (i == 1) {
                    int next_node = node * 2;
                    if (next_node <= y && !visited[next_node]) {
                        visited[next_node] = true;
                        q.add(new int[]{next_node, oper_count+1});
                    }
                } else {
                    int next_node = node * 3;
                    if (next_node <= y && !visited[next_node]) {
                        visited[next_node] = true;
                        q.add(new int[]{next_node, oper_count+1});
                    }
                }
            }
        }
        return -1;
    }
}