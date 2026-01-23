import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int startRow = (int) (left / n) + 1;
        int startCol = (int) (left % n) + 1;
        System.out.println("startRow: " + startRow + " " + "startCol: " + startCol);
        
        int checkCount = (int) Math.abs(left - right) + 1;
        int[] resultArr = new int[checkCount];
        int nowCount = 0;
        
        for (int i = startRow; i <= n; i++) {
            int jStart = (i == startRow) ? startCol : 1;
            
            for (int j = jStart; j <= n; j++) {
                if (nowCount == checkCount) {
                    break;
                }
                resultArr[nowCount] = Math.max(i,j);
                nowCount++;
            }
            if (nowCount == checkCount) {
                    break;
                }
        }
        
        
            
            
        return resultArr;
    }
}