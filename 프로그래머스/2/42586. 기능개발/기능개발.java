import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            int left_progress = 100 - progresses[i];
            int left_day = 0;
            
            while (left_progress > 0) {
                left_progress -= speeds[i];
                left_day++;
            }
            
            day[i] = left_day;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < day.length; i++) {
            if (queue.isEmpty()) {
                queue.add(day[i]);
            } else if (queue.peek() >= day[i]) {
                queue.add(day[i]);
            } else {
                int count = 0;
                while (!queue.isEmpty()) {
                    int a = queue.poll();
                    count++;
                }
                answer.add(count);
                queue.add(day[i]);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            count++;
        }
        answer.add(count);
        
        System.out.println(answer);
        int[] arr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        
        return arr;
    }
}