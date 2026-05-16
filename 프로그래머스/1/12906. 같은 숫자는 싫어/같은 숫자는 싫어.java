import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (queue.peek() == arr[i]) {
                continue;
            } else {
                list.add(queue.poll());
                queue.add(arr[i]);
            }
        }
        
        list.add(queue.poll());
        
        int[] answer = new int[list.size()];
        
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}