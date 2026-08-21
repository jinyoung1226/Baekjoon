import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int result = 0;
        boolean flag = true;
        
        for (int i = 0; i < enemy.length; i++) {
            if (n >= enemy[i]) {
                pq.add(enemy[i]);
                n -= enemy[i];
            } else {
                if (k == 0) {
                    result = i;
                    flag = false;
                    break;
                }
                
                if (!pq.isEmpty() && pq.peek() >= enemy[i]) {
                    int poll = pq.poll();
                    n += poll;
                    pq.add(enemy[i]);
                    n -= enemy[i];
                    k--;
                } else {
                    k--;
                }
            }
        }
        
        if (flag) {
            return enemy.length;
        } else {
            return result;
        }
    }
}