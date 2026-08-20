import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        TreeMap<Integer, List<int[]>> result = new TreeMap<>((o1, o2) -> o1 - o2);
        HashMap<String, Integer> gemMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) set.add(gems[i]);
        int left = 0;
        int right = 0;
        int matchCount = set.size();
        gemMap.put(gems[left], 1);
        
        while (right <= gems.length - 1) {
            if (matchCount != gemMap.size()) {
                right++;
                if (right >= gems.length) {
                    break;
                }
                gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
            } else {
                int length = right - left + 1;
                int[] arr = new int[]{left+1, right+1};
                if (result.containsKey(length)) {
                    result.get(length).add(arr);
                } else {
                    result.put(length, new ArrayList<>());
                    result.get(length).add(arr);
                }
                
                if (gemMap.get(gems[left]) == 1) {
                    gemMap.remove(gems[left]);
                } else {
                    gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                }
                
                left++;
            }
        }
        
        List<int[]> resultList = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : result.entrySet()) {
            for (int[] arr : entry.getValue()) {
                resultList.add(arr);
            }
            break;
        }
        
        Collections.sort(resultList, (o1, o2) -> o1[0] - o2[0]);
        return resultList.get(0);
    }
}