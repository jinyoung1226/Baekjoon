import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        
        int[] combArr = new int[5];
        combination(arr, combArr, 0, 0, q, ans);
        
        
        return answer;
    }
    
    void combination(int[] arr, int[] combArr, int depth, int step, int[][] q, int[] ans) {
        if (depth == 5) {
            if (check(combArr, q, ans)) {
                answer++;
            }
            return;
        }
        
        for (int i = step; i < arr.length; i++) {
            combArr[depth] = arr[i];
            combination(arr, combArr, depth + 1, i + 1, q, ans);
        }
    }
    
    boolean check(int[] combArr, int[][] q, int[] ans) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < combArr.length; i++) {
            set.add(combArr[i]);
        }
        
        
        for (int i = 0; i < q.length; i++) {
            int[] arr = q[i];
            int answer = ans[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    count++;
                }
            }
            
            if (count != answer) {
                return false;
            }
        }
        return true;
    }
}