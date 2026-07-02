import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->  o2 - o1);
        long result = 0;
        for (int i : works) pq.add(i);
        
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                Integer num = pq.poll() - 1;
                if (num != 0) pq.add(num);
            } else break;
        }
        
        while (!pq.isEmpty()) {
            Integer number = pq.poll();
            result += Math.pow(number, 2);
        }
        
        return result;
    }
}