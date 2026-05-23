import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    Integer max = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];
            graph[first].add(second);
            graph[second].add(first);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];
            graph[first].remove(Integer.valueOf(second));
            graph[second].remove(Integer.valueOf(first));
            
            visited = new boolean[n+1];
            int count = bfs(1);
            int anotherCount = n - count;
            
            max = Math.min(max, Math.abs(count - anotherCount));
            graph[first].add(second);
            graph[second].add(first);
        }
        
        return max;

    }
    
    public int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count = 1;
        visited[start] = true;
        
        while(!q.isEmpty()) {
            Integer now = q.poll();
            
            for (Integer next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}