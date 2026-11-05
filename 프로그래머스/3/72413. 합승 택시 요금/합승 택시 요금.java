import java.util.*;

class Solution {
    class Node {
        int x;
        int cost;
        
        public Node (int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
    int[] togetherDist;
    boolean[] togetherVisited;
    int[] dist;
    boolean[] visited;
    List<Node>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        togetherVisited = new boolean[n+1];
        togetherDist = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            togetherDist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int cost = fares[i][2];
            graph[x].add(new Node(y, cost));
            graph[y].add(new Node(x, cost));
        }
        
        dijkstra(s, togetherDist, togetherVisited);
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < togetherDist.length; i++) {
            int total = togetherDist[i];
            visited = new boolean[n+1];
            dist = new int[n+1];
            for (int j = 0; j < graph.length; j++) {
                dist[j] = Integer.MAX_VALUE;
            }
            
            dijkstra(i, dist, visited);
            total += (dist[a] + dist[b]);
            answer = Math.min(answer, total);
        }
        
        
        
        return answer;
    }
    
    void dijkstra(int start, int[] dist, boolean[] visited) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (!visited[now.x]) {
                visited[now.x] = true;
            } else {
                continue;
            }
            
            for (Node next : graph[now.x]) {
                if (dist[next.x] > next.cost + now.cost) {
                    dist[next.x] = next.cost + now.cost;
                    pq.add(new Node(next.x, dist[next.x]));
                }
            }
        }
    }
}