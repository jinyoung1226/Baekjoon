import java.util.*;

class Solution {
    
    static int[] count_arr;
    
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        
        count_arr = new int[tangerine[tangerine.length-1] + 1];
        
        for (int i = 0; i < tangerine.length; i++) {
            count_arr[tangerine[i]] += 1;
        }
        
        Integer[] count_arr1 = new Integer[count_arr.length];
        for (int i = 0; i < count_arr1.length; i++) {
            count_arr1[i] = count_arr[i];
        }
        
        Arrays.sort(count_arr1, Collections.reverseOrder());
        
        int count = 0;
        int tmp = 0;
        for (int i = 0; i < count_arr1.length; i++) {
            tmp += count_arr1[i];
            if(tmp < k) {
                count++;
                continue;
            } else {
                count++;
                break;
            }
        }
        
        return count;
        
    }
}