import java.util.*;

class Solution {
    
    public int solution(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            List<Character> list = new ArrayList<>();
            
            for (int j = i; j < i+s.length(); j++) {
                list.add(s.charAt(j % s.length()));
            }
            
            Stack<Character> stack = new Stack<>();
            
            boolean check = true;
            for (int j = 0; j < list.size(); j++) {
                if (stack.isEmpty() && (list.get(j) == ']' || list.get(j) == ')' || list.get(j) == '}')) {
                    check = false;
                    break;
                } 
                
                if (list.get(j) == '[' || list.get(j) == '(' || list.get(j) == '{') {
                    stack.push(list.get(j));
                }
                
                if (list.get(j) == ']') {
                    if (stack.peek() != '[') {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                
                if (list.get(j) == ')') {
                    if (stack.peek() != '(') {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                
                if (list.get(j) == '}') {
                    if (stack.peek() != '{') {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            
            if (check && stack.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
}