import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int count = 0;
    
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    graph[i+1].add(j+1);
                }
            }
        }
        
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        return count;
    }
    
    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            Integer now = q.poll();
            
            for (Integer next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}