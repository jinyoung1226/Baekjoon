import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        int idx = 0;
        int result = 0;
        while (map.size() != 0) {
            if (idx > topping.length - 1) break;
            
            int key = topping[idx];
            
            map.put(key, map.get(key) - 1);
            if (map.get(key).equals(0)) {
                map.remove(key);
            }
            
            set.add(key);
            if (set.size() == map.size()) result++;
            idx++;
        }
        
        return result;
    }
}