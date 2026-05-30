import java.util.*;

class Solution {
    boolean[] visited;
    List<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        String answer = list.get(0);
        
        String[] data = answer.split(" ");
        return data;
        

    }
    
    public void dfs(int depth, String start, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        
        return;
    }
}