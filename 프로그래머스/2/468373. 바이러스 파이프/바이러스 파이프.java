import java.util.*;

class Solution {
    List<int[]>[] graph;
    boolean[] visited;
    int[] type_arr;
    int result = Integer.MIN_VALUE;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new ArrayList[n+1];
        type_arr = new int[k];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int type = edges[i][2];
            
            graph[x].add(new int[]{y, type});
            graph[y].add(new int[]{x, type});
        }
        
        perm(0, k, n, infection);
        
        return result;
    }
    
    public void perm(int depth, int k, int n, int infection) {
        if (depth == k) {
            visited = new boolean[n+1];
            int max = Search(type_arr, infection);
            result = Math.max(result, max);
            return;
        }
        
        for (int i = 1; i < 4; i++) {
            type_arr[depth] = i;
            perm(depth + 1, k, n, infection);
        }
        
    }
    
    public int Search(int[] arr, int infection) {
        int infection_count = 1;
        List<Integer> list = new ArrayList<>();
        list.add(infection);
        visited[infection] = true;
        
        for (int pipe : arr) {
            Queue<Integer> q = new LinkedList<>();
            for (Integer node : list) {
                q.add(node);
            }
            
            while (!q.isEmpty()) {
                int real_node = q.poll();
                for (int[] connect : graph[real_node]) {
                    if (!visited[connect[0]] && connect[1] == pipe) {
                        visited[connect[0]] = true;
                        infection_count++;
                        q.add(connect[0]);
                        list.add(connect[0]);
                    }
                }
            }
        }
        
        return infection_count;
    }
}
