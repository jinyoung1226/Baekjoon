import java.util.*;

class Solution {
    int[] dist;
    boolean[] visited;
    List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        BFS(1);
        
        Integer max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            if (max < dist[i]) {
                count = 0;
                count++;
                max = dist[i];
            } else if (max == dist[i]) {
                count++;
            } else {
                continue;
            }
        }
        
        return count;

    }
    
    public void BFS(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for (Integer next : graph[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, now[1] + 1});
                    dist[next] = now[1] + 1;
                }
            }
        }
    }
}