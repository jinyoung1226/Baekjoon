import java.util.*;

class Solution {
    
    static int cum_result = 0;
    static Integer[] A_arr;
    static Integer[] B_arr;
    
    public int solution(int []A, int []B) {
        A_arr = new Integer[A.length];
        B_arr = new Integer[B.length];
        
        // A 배열 Integer 배열로 변환
        for (int i = 0; i < A.length; i++) {
            A_arr[i] = A[i];
        }
        
        // B 배열 Integer 배열로 변환
        for (int i = 0; i < B.length; i++) {
            B_arr[i] = B[i];
        }
        
        // A는 오름차순, B는 내림차순 정렬
        Arrays.sort(A_arr);
        Arrays.sort(B_arr, Collections.reverseOrder());
        
        
        for (int i = 0; i < A.length; i++) {
            int tmp = A_arr[i] * B_arr[i];
            cum_result += tmp;
        }
        
        return cum_result;
    }
}