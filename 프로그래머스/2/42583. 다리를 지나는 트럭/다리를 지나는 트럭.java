import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    time++;
                    sum += truck;
                    break;
                } else if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                } else {
                    if (sum + truck > weight) {
                        bridge.add(0);
                        time++;
                    } else {
                        bridge.add(truck);
                        time++;
                        sum += truck;
                        break;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}