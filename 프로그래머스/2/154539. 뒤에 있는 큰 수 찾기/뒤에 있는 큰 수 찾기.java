import java.util.*;

class Solution {
    class Point {
        int idx;
        int num;
        
        public Point(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public int[] solution(int[] numbers) {
        Stack<Point> stack = new Stack<>();
        int[] result = new int[numbers.length];
        
        stack.push(new Point(0, numbers[0]));
        for (int i = 1; i < numbers.length; i++) {
            Point point = new Point(i, numbers[i]);
            if (stack.peek().num >= point.num) {
                stack.push(point);
            } else {
                while (!stack.isEmpty() && stack.peek().num < point.num) {
                    Point out = stack.pop();
                    result[out.idx] = point.num;
                }
                stack.push(point);
            }
        }
        
        while (!stack.isEmpty()) {
            Point out = stack.pop();
            result[out.idx] = -1;
        }
        
        return result;
    }
}