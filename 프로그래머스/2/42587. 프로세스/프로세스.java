import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    queue.poll();
                    count++;
                    if (i == location) {
                        return count;
                    }
                }
            }
        }
        
        return count;
    }
}