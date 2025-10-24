import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            List<Integer> list = new ArrayList<>();
            for (int b = i-1; b < j; b++) {
                list.add(array[b]);
            }
            
            int[] new_arr = new int[j-i+1];
            
            for (int b = 0; b < list.size(); b++) {
                new_arr[b] = list.get(b);
            }
            Arrays.sort(new_arr);
            
            result[a] = new_arr[k-1];
        }
        return result;
    }
}