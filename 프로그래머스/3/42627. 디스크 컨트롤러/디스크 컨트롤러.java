import java.util.*;

class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            } else {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
    int time  =0;
    int count = 0;
    int idx = 0;
    int result = 0;
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                time += now[2];
                result += (time - now[1]);
                count++;
            } else {
                time = jobs[idx][0];
            }
        }
        
        result = result / jobs.length;
        return result;
    }
}