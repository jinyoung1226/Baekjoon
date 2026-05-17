import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] arr = commands[i];
            int start = arr[0];
            int end = arr[1];
            int k = arr[2];
            
            List<Integer> list = new ArrayList<>();
            for (int j = start-1; j < end; j++) {
                list.add(array[j]);
            }
            
            Collections.sort(list);
            int result = list.get(k-1);
            answer[i] = result;

        }
        
        return answer;
    }
}