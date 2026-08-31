import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (Integer.compare(o1[col-1], o2[col-1]) == 0) {
                return Integer.compare(o2[0], o1[0]);
            } else {
                return Integer.compare(o1[col-1], o2[col-1]);
            }
        });
        
        int[] arr = new int[data.length+1];
        for (int i = 0; i < data.length; i++) {
            int save = 0;
            for (int j = 0; j < data[i].length; j++) {
                save += data[i][j] % (i+1);
            }
            arr[i+1] = save;
        }
        
        
        int result = 0;
        for (int i = row_begin; i < row_end+1; i++) {
            result ^= arr[i];
        }

        return result;
    }
}