import java.util.*;

class Solution {
    List<int[]>[] graph;
    int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        for (int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < road.length; i++) {
            int node1 = road[i][0];
            int node2 = road[i][1];
            int cost = road[i][2];
            
            graph[node1].add(new int[]{node2, cost});
            graph[node2].add(new int[]{node1, cost});
        }
        
        dijkstra(1);
        
        int answer = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            
            int currentNode = now[0];
            int currentCost = now[1];
            
            if (dist[currentNode] > currentCost) continue;
            
            for (int[] next : graph[currentNode]) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                if (dist[nextNode] > currentCost + nextCost) {
                    dist[nextNode] = currentCost + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}