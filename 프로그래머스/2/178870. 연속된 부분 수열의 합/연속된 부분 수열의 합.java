import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int start = 0;
        int end = sequence.length;
        int minLength = Integer.MAX_VALUE;
        while(right < sequence.length) {
            if (sum == k) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                    start = left;
                    end = right;
                }
                
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        
        return new int[]{start, end};
    }
}