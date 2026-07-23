import java.util.*;

class Solution {
    List<int[]>[] graph;
    int[] dist;
    boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < road.length; i++) {
            graph[road[i][0]].add(new int[]{road[i][1], road[i][2]});
            graph[road[i][1]].add(new int[]{road[i][0], road[i][2]});
        }
        
        dijkstra(1);
        
        int result = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= K) {
                result++;
            }
        }
        
        return result;
        
    }
    
    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if (visited[now[0]]) {
                continue;
            } else {
                visited[now[0]] = true;
            }
            
            for (int[] next : graph[now[0]]) {
                if (dist[next[0]] > now[1] + next[1]) {
                    dist[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }
    
   
}