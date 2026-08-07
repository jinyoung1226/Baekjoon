import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        int time = 0;
        HashMap<Integer, Integer> server = new HashMap<>();
        
        while (time <= 23) {
            int serverCount = 0;
            for (Map.Entry<Integer, Integer> entry : server.entrySet()) {
                int end = entry.getValue();
                if (time <= end) {
                    serverCount++;
                }
            }
            
            if (players[time] == 0) {
                time++;
                continue;
            }
            
            int requiredServer = players[time] / m;
            if (requiredServer > serverCount) {
                int addServerCount = requiredServer - serverCount;
                for (int i = 0; i < addServerCount; i++) {
                    server.put(result + 1, time + k - 1);
                    result++;
                }
            }
            
            
            time++;
        }

        return result;
    }
}