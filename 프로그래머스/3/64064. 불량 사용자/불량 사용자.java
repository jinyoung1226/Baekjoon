import java.util.*;

class Solution {
    HashSet<List<String>> set = new HashSet<>();
    String[] user_ids;
    String[] banned_ids;
    boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        user_ids = user_id.clone();
        banned_ids = banned_id.clone();
        visited = new boolean[user_id.length];
        dfs(0, new ArrayList<>());
        return set.size();
    }
    
    public void dfs(int index, List<String> chosen) {
        if (index == banned_ids.length) {
            List<String> list = new ArrayList<>(chosen);
            Collections.sort(list);
            set.add(list);
            return;
        }
        
        for (int i = 0; i < user_ids.length; i++) {
            if (!visited[i] && isMatch(user_ids[i], banned_ids[index])) {
                visited[i] = true;
                chosen.add(user_ids[i]);
                dfs(index + 1, chosen);
                chosen.remove(chosen.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false;
        
        boolean flag = true;
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            } else {
                if (ban.charAt(i) != user.charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}