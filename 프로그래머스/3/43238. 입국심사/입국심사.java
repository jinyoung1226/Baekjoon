import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        Arrays.sort(times);
        long right = (long) n * times[times.length - 1];
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            
            if (count >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}