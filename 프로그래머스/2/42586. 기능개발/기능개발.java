import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            Integer count = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(count);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int count = 1;
            int num = queue.poll();
            if (queue.isEmpty()) {
                list.add(count);
                break;
            }
            while(true) {
                if (queue.peek() != null && queue.peek() <= num) {
                    queue.poll();
                    count++;
                } else {
                    break;
                }
            } 
            list.add(count);
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
}