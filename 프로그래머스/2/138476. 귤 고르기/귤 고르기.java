import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            list.add(i);
        }
        
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        
        int count = 0;
        for (Integer i : list) {
            k -= map.get(i);
            count++;
            if (k <= 0) {
                break;
            }
        }
        
        return count;
        
    }
}