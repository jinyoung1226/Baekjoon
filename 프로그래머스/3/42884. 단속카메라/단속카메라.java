import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int idx = 0;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int out = routes[0][1];
        
        while (idx < routes.length) {
            while (idx < routes.length && out >= routes[idx][0] && out <= routes[idx][1]) {
                idx++;
            }
            
            answer++;
            if (idx == routes.length) {
                break;
            }
            out = routes[idx][1];
        }
        
        return answer;
    }
}