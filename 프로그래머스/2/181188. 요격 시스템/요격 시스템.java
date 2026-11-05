import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int range = targets[0][1];
        int answer = 0;
        for (int i = 1; i < targets.length; i++) {
            if (range <= targets[i][0]) {
                range = targets[i][1];
                answer++;
            }
        }
        
        answer++;
        
        
        return answer;
    }
}