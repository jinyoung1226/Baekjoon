import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> main_belt = new LinkedList<>();
        Stack<Integer> sub_belt = new Stack<>();
        int belt_idx = 0;
        List<Integer> result = new ArrayList<>();
        
        int num = 1;
        for (int i = 0; i < order.length; i++) {
            main_belt.add(num++);
        }
        
        while (true) {
            if (!main_belt.isEmpty()) { // 메인 컨테이너 벨트가 비어있지 않을 때
                if (main_belt.peek() == order[belt_idx]) { // 메인 컨테이너 벨트의 맨 앞의 상자가 순서랑 동일할 때
                    result.add(main_belt.poll());
                    belt_idx++;
                    
                } else { // 메인 컨테이너 벨트의 맨 앞의 상자가 순서랑 동일하지 않을 때
                    if (!sub_belt.isEmpty()) { // 서브 컨테이너 벨트가 비어있지 않을 때
                        if (sub_belt.peek() == order[belt_idx]) {
                            result.add(sub_belt.pop());
                            belt_idx++;
                        } else {
                            sub_belt.push(main_belt.poll());
                        }
                    } else { // 서브 컨테이너 벨트가 비어있을 떄
                        sub_belt.push(main_belt.poll());
                    }
                }
                
            } else { // 메인 컨테이너 벨트가 비어있을 떄
                if (!sub_belt.isEmpty()) { // 서브 컨테이너 벨트가 비어있지 않을 때
                    if (sub_belt.peek() == order[belt_idx]) {
                            result.add(sub_belt.pop());
                            belt_idx++;
                        } else {
                            break;
                        }
                } else { // 서브 컨테이너 벨트가 비어있을 떄
                    break;
                }
            }
        }

        return result.size();
    }
}