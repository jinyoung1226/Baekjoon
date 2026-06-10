import java.util.*;

class Solution {
    
    
    public int solution(int[] mats, String[][] park) {
        int result = Integer.MIN_VALUE;
        for (int size : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    if (park[i][j].equals("-1")) {
                        if (checkPlace(i, j, size, park)) {
                            result = Math.max(result, size);
                        }
                    }
                }
            }
        }
        
        return result == Integer.MIN_VALUE ? -1 : result;
    }
    
    public boolean checkPlace(int x, int y, int size, String[][] park) {
        int row = park.length;
        int col = park[0].length;
        
        if (x + size > row || y + size > col) {
            return false;
        }
        
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}