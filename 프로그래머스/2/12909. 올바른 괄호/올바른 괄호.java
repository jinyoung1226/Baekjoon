import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty() && ch == ')') {
                stack.pop();
            } else if (stack.isEmpty() && ch == ')') {
                answer = false;
                break;
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }
        

        return answer;
    }
}