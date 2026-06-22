import java.util.*;

class Solution {
    HashMap<String, Integer> check_want_map = new HashMap<>();
    HashMap<String, Integer> save_want_map = new HashMap<>();
    int leftIdx = 0;
    int rightIdx = 9;
    int result = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            check_want_map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            save_want_map.put(discount[i], save_want_map.getOrDefault(discount[i], 0) + 1);
        }
        
        while (rightIdx < discount.length) {
            boolean check = true;
            for (Map.Entry<String, Integer> entry : save_want_map.entrySet()) {
                if (!check_want_map.containsKey(entry.getKey())) {
                    check = false;
                    break;
                }
                
                if (entry.getValue() != check_want_map.get(entry.getKey())) {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                result++;
            }
            
            if (rightIdx == discount.length - 1) {
                break;
            }
            rightIdx++;
            
            
            if (save_want_map.get(discount[leftIdx]) >= 2) {
                save_want_map.put(discount[leftIdx], save_want_map.get(discount[leftIdx]) - 1);
            } else {
                save_want_map.remove(discount[leftIdx]);
            }
            
            if (save_want_map.containsKey(discount[rightIdx])) {
                save_want_map.put(discount[rightIdx], save_want_map.get(discount[rightIdx]) + 1);
            } else {
                save_want_map.put(discount[rightIdx], 1);
            }
            
            leftIdx++;
        }
        
        return result;
    }
}