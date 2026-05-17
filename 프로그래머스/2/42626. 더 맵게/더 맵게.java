import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            
            int newScoville = first + (second * 2);
            pq.add(newScoville);
            answer++;
        }
        
        return answer;
    }
}