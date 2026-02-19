import java.util.*;

class Solution {
    
    static String[] alpabet = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0);
        
        
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                result = i;
                break;
            }
        }
        
        return result;
        
    }
    
    public void dfs(StringBuilder sb, int depth) {
        list.add(sb.toString());

        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            sb.append(alpabet[i]);
            dfs(sb, depth+1);
            sb.deleteCharAt(sb.toString().length()-1);
        }
    }
}