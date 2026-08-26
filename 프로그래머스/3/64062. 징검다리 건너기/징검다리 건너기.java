import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int check = (left + right) / 2 - 1;
            
            int[] arr = stones.clone();
            boolean flag = sliding(check, arr, k);
            
            if (flag) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        
        return result;
    }
    
    public boolean sliding(int check, int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= check) {
                arr[i] = 0;
            }
        }
        
        int left = 0;
        int right = k - 1;
        int sum = 0;
        for (int i = 0; i <= right; i++) {
            sum += arr[i];
        }
        
        if (sum == 0) {
            return false;
        }
        
        while (true) {
            if (right+1 <= arr.length -1) {
                sum -= arr[left];
                left++;
                sum += arr[right + 1];
                right++;
                
                if (sum == 0) {
                    return false;
                }
            } else {
                break;
            }
        }
        
        
        return true;
    }
}