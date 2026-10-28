import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = 0;
        
        
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            long result = calculateLevel(mid, diffs, times);
            
            if (result <= limit) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
    
    public long calculateLevel(int level, int[] diffs, int[] times) {
        long time = times[0];
        for (int i = 1; i < diffs.length; i++) {
            int diff = diffs[i]; // 현재 퍼즐의 난이도
            int time_cur = times[i]; // 현재 퍼즐 소요 시간
            int time_prev = times[i-1]; // 이전 퍼즐의 난이도
                
            if (diff <= level) {
                time += time_cur;
            } else {
                time += (time_cur + time_prev)* (diff - level) + time_cur;
            }
        }
        
        return time;
    }
}