import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    PriorityQueue<String[]> q = new PriorityQueue<>((o1, o2) -> {
        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
    });
    Stack<String[]> stack = new Stack<>();
    public String[] solution(String[][] plans) {
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String playtime = plans[i][2];
            String[] hourAndMinute = plans[i][1].split(":");
            String start = String.valueOf(((Integer.parseInt(hourAndMinute[0]) * 60) + Integer.parseInt(hourAndMinute[1])));
            q.add(new String[]{name, start, playtime});
        }
        
        String[] now = q.poll();
        String nowName = now[0];
        int    nowTime = Integer.parseInt(now[1]);
        int    playTime = Integer.parseInt(now[2]);
        
        while (result.size() != plans.length) {
            // 현재 과제가 끝났을 경우
            if (playTime == 0) {
                result.add(nowName);
                
                // 현재 과제가 끝났는데, 끝난 시점의 nowTime이 다음 순서 start와 동일할 때
                if (!q.isEmpty() && Integer.parseInt(q.peek()[1]) == nowTime) {
                    String[] next = q.poll();
                    nowName = next[0];
                    playTime = Integer.parseInt(next[2]);
                }
                
                // 현재 과제가 끝났는데, 끝난 시점에도 맞는 데이터가 없을 때
                else {
                    // 그 중에서 스택에 남아있는 게 있을 경우
                    if (!stack.isEmpty()) {
                        String[] next = stack.pop();
                        nowName = next[0];
                        playTime = Integer.parseInt(next[1]);
                    }
                }
            } 
            
            // 현재 과제가 끝나지 않았을 경우
            else {
                
                // 현재 과제가 끝나지 않았는데, nowTime이 다음 순서 start와 동일할 때
                if (!q.isEmpty() && Integer.parseInt(q.peek()[1]) == nowTime) {
                    stack.push(new String[]{nowName, String.valueOf(playTime)});
                    String[] next = q.poll();
                    nowName = next[0];
                    playTime = Integer.parseInt(next[2]);
                }
            }
            
            nowTime++;
            playTime--;
        }
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}