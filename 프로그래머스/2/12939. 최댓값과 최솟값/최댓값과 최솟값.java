import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] string_arr = s.split(" ");
        int[] arr = new int[string_arr.length];
        
        for (int i = 0; i < string_arr.length; i++) {
            arr[i] = Integer.parseInt(string_arr[i]);
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }
        
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}