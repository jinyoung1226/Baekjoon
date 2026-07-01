import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int union = 0;
        int same = 0;
        
        for (int i = 0; i < str1.length() -1; i++) {
            if (str1.charAt(i) >= 97 && str1.charAt(i) <= 122 && str1.charAt(i+1) >= 97 && str1.charAt(i+1) <= 122) {
                String str = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i+1));
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }
        for (int i = 0; i < str2.length() -1; i++) {
            if (str2.charAt(i) >= 97 && str2.charAt(i) <= 122 && str2.charAt(i+1) >= 97 && str2.charAt(i+1) <= 122) {
                String str = String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i+1));
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }
        

        
        if (map1.size() > map2.size()) {
            for (Map.Entry<String,Integer> map : map1.entrySet()) {
                if (map2.containsKey(map.getKey())) {
                    same += Math.min(map.getValue(), map2.get(map.getKey()));
                    union += Math.max(map.getValue(), map2.get(map.getKey()));
                    map2.remove(map.getKey());
                } else {
                    union += map.getValue();
                }
            }
            if (map2.size() >= 1) {
                for (Integer i : map2.values()) {
                    union += i;
                }
            }
        } else {
            for (Map.Entry<String,Integer> map : map2.entrySet()) {
                if (map1.containsKey(map.getKey())) {
                    same += Math.min(map.getValue(), map1.get(map.getKey()));
                    union += Math.max(map.getValue(), map1.get(map.getKey()));
                    map1.remove(map.getKey());
                } else {
                    union += map.getValue();
                }
            }
            if (map1.size() >= 1) {
                for (Integer i : map1.values()) {
                    union += i;
                }
            }
        }
        
        if (union == 0) {
            return 1*65536;
        } else {
            double b = (double) same / (double) union * 65536;
            
            return (int) b;
        }
        

    }
}