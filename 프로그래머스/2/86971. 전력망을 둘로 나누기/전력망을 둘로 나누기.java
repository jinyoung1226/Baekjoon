import java.util.*;

class Solution {
    
    static List<Integer>[] arr;
    static boolean[] visited;
    static Integer result = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        int jump = 0;
        for (int i = 0; i < wires.length; i++) {
            
            // 인접리스트 초기화
            arr = new ArrayList[n+1];
            for (int j = 0; j <= n; j++) {
                arr[j] = new ArrayList<>();
            }
            
            // 하나씩 뺀 걸 기반으로 BFS로 탐색
            for (int j = 0; j < wires.length; j++) {
                if (jump == j) continue;
                
                int first = wires[j][0];
                int second = wires[j][1];
                arr[first].add(second);
                arr[second].add(first);
            }
            
            
            // BFS 탐색
            int firstCount = BFS(1);
            int secondCount = Math.abs(n-firstCount);
            int lastCount = Math.abs(firstCount - secondCount);
            
            
            result = Math.min(result,lastCount);
            jump++;
        }
        return result;
    }
    
    public int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[arr.length];
        q.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!q.isEmpty()) {
            Integer now = q.poll();
            
            for (Integer next : arr[now]) {
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