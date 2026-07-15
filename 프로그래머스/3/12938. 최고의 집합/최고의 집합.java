import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int num = s / n;
        int mod = s % n;
        
        Arrays.fill(answer, num);
        
        if (mod == 0) {
            return answer;
        }
        
        for (int i = 0; i < mod; i++) {
            answer[n - i - 1] = answer[n - i - 1] + 1;
        }
        
        return answer;
    }
}