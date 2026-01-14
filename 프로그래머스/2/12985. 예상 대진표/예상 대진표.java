import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {
        int count = 0; 

        while (a != b) {
            count++;
            
            // a 처리
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a /= 2;
                a++;
            }
            
            // b 처리
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b /= 2;
                b++;
            }
        }

        return count;
    }
}