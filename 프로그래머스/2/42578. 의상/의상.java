import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothCount = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String key = cloth[1];
            clothCount.put(key, clothCount.getOrDefault(key, 0) + 1);
        }
        
        int result = 1;
        for (Integer count : clothCount.values()) {
            result *= (count+1);
        }
        
        return result - 1;
    }
}