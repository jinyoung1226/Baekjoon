import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        boolean success = false;
        long queue1_sum = 0;
        long queue2_sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            queue1_sum += queue1[i];
            queue2_sum += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        for (int i = 0; i < queue1.length*3; i++) {
            if (queue1_sum == queue2_sum) {
                success = true;
                break;
            }
            
            if (queue1_sum > queue2_sum) {
                int poll = q1.poll();
                queue1_sum -= poll;
                q2.add(poll);
                queue2_sum += poll;
            } else {
                int poll = q2.poll();
                queue2_sum -= poll;
                q1.add(poll);
                queue1_sum += poll;
            }
            
            count++;
        }
        
        if (success) {
            return count;
        } else {
            return -1;
        }
    }
}