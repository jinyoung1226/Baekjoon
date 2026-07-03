import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length()-2).replace("},{", "-").split("-");
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        HashSet<Integer> set = new HashSet<>();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            String[] s_arr = temp.split(",");
            for (int j = 0; j < s_arr.length; j++) {
                if (!set.contains(Integer.valueOf(s_arr[j]))) {
                    set.add(Integer.valueOf(s_arr[j]));
                    list.add(Integer.valueOf(s_arr[j]));
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}