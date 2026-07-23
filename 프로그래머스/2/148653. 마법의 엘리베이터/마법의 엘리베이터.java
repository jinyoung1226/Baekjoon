import java.util.*;

class Solution {
    public int solution(int storey) {
        String storey_str = String.valueOf(storey);
        int[] arr = new int[storey_str.length()];
        
        for (int i = 0; i < storey_str.length(); i++) {
            arr[i] = Integer.valueOf(storey_str.charAt(i) - '0');
        }
        
        int count = 0;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (arr[i] > 5) {
                    count += (10 - arr[i]) + 1;  // 올림 + 마지막 1번
                } else {
                    count += arr[i];             // 내려가기
                }
                break;
            }
            if (arr[i] > 0 && arr[i] < 5) {
                count += arr[i];
            } 
            
            if (arr[i] == 5) {
                if (arr[i-1] >= 5) {
                    count += (10 - arr[i]);
                    arr[i-1]++;
                } else {
                    count += arr[i];
                }
            } 
            if (arr[i] > 5) {
                count += (10 - arr[i]);
                arr[i-1]++;
            }
        }
        
        return count;
    }
}