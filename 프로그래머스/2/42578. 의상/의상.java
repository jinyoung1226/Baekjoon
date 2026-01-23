import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        System.out.println(clothes.length);
        for (int i = 0; i < clothes.length; i++) {
            String clothName = clothes[i][0];
            String clothKind = clothes[i][1];
            
            map.put(clothKind, map.getOrDefault(clothKind, 0) + 1);
        }
        
        System.out.println(map);
        
        int count = 1;
        for (String key : map.keySet()) {
            count *= map.get(key)+ 1;
        }
        
        return count-1;
    }
}