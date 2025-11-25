import java.util.*;

class Solution {
    
    static int[] arr; 
    static int result = 0;
    
    public int solution(int n) {
        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;    
        }
        
        sliding_window(arr, n);
        
        return result;
    }
    
    public void sliding_window(int[] arr, int n) {
        int start = 0;
        int end = 0;
        
        while (start <= end) {
            int tmp = 0;
            for (int i = start; i <= end; i++) {
                 tmp += arr[i];
             }
            
            if (tmp == n) {
                result++;
                end++;
            } else if (tmp < n) {
                end++;
            } else {
                start++;
            }
            
            if (end == n) {
                break;
            }
        }
    }
}