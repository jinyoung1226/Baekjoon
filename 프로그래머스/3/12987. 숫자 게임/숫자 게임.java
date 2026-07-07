import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 그리디 + 투 포인터(두 배열에 투 포인터도 쓸 수 있다는 걸 인지 해야 한다.)
        int A_idx = 0;
        int B_idx = 0;
        int cnt = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        while (A_idx <= A.length - 1 && B_idx <= B.length - 1) {
            if (A[A_idx] < B[B_idx]) {
                cnt++;
                A_idx++;
                B_idx++;
            } else {
                B_idx++;
            }
        }
        
        return cnt;
    }
}