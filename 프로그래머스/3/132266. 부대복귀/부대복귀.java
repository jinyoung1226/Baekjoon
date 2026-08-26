import java.util.*;

class Solution {
    List<Integer>[] roadMap;
    boolean[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        roadMap = new ArrayList[n+1];
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
        
        int[] resultArr = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int result = bfs(sources[i], destination);
            resultArr[i] = result;
            visited = new boolean[n+1];
        }
        
        return resultArr;
    }
    
    public int bfs(int start, int destination) {
        boolean flag = false;
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.add(new int[]{start, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == destination) {
                flag = true;
                result = now[1];
                break;
            }
            
            for (Integer next : roadMap[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, now[1] + 1});
                }
            }
        }
        
        if (flag) {
            return result;
        } else {
            return -1;
        }
    }
}