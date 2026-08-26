import java.util.*;

class Solution {
    List<Integer>[] roadMap;
    int[] dist;
    boolean[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        roadMap = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i < roadMap.length; i++) {
            roadMap[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int v1 = roads[i][0];
            int v2 = roads[i][1];
            roadMap[v1].add(v2);
            roadMap[v2].add(v1);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(destination);
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = dist[sources[i]];
        }
        
        
        return result;
    }
    
    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if (!visited[now[0]]) {
                visited[now[0]] = true;
            } else {
                continue;
            }
            
            for (Integer next : roadMap[now[0]]) {
                if (dist[next] > now[1] + 1) {
                    dist[next] = now[1] + 1;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
    }
}