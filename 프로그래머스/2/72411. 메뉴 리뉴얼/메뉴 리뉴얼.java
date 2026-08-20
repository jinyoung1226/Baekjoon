import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        
        for (int i = 0; i < orders.length; i++) {
            int length = orders[i].length();
            for (int j : course) {
                if (length >= j) {
                    StringBuilder sb = new StringBuilder();
                    comb(orders[i], sb, j, 0, 0);
                }
            }
        }
        
        HashMap<Integer, TreeMap<Integer, List<String>>> checkMap = new HashMap<>();
        for (int i : course) {
            checkMap.put(i, new TreeMap<>((o1, o2) -> o2 - o1));
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String menu = entry.getKey();
            Integer count = entry.getValue();
            int length = menu.length();
            
            if (!checkMap.get(length).containsKey(count)) {
                checkMap.get(length).put(count, new ArrayList<>());
            }
            checkMap.get(length).get(count).add(menu);
        }
        
        List<String> result = new ArrayList<>();
        for (int i : course) {
            TreeMap<Integer, List<String>> exMap = checkMap.get(i);
            for (Map.Entry<Integer, List<String>> entry : exMap.entrySet()) {
                if (entry.getKey() == 1) continue;
                List<String> list = entry.getValue();
                for (String s :list) {
                    result.add(s);
                }
                break;
            }
        }
        Collections.sort(result);
        String[] arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
    
    public void comb(String str, StringBuilder sb, int k, int idx, int n) {
        if (n == k) {
            char[] chrArr = sb.toString().toCharArray();
            Arrays.sort(chrArr);
            String sortedStr = new String(chrArr);
            map.put(sortedStr, map.getOrDefault(sortedStr, 0) + 1);
            return;
        }
        
        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            comb(str, sb, k, i+1, n+1);
            sb.deleteCharAt(sb.toString().length()-1);
        }
    }
}