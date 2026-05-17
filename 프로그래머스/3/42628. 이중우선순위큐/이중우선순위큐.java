import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];    
            String[] oper_arr = operation.split(" ");
            
            if (oper_arr[0].equals("I")) {
                maxQueue.add(Integer.valueOf(oper_arr[1]));
                minQueue.add(Integer.valueOf(oper_arr[1]));
            } else {
                if (oper_arr[1].equals("-1") && !minQueue.isEmpty()) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                } else if (oper_arr[1].equals("1") && !maxQueue.isEmpty()){
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
            }
        }
        
        int[] answer = new int[2];
        if (maxQueue.isEmpty() && minQueue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        } else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
            return answer;
        }
    }
}