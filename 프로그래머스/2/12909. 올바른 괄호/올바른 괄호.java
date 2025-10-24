import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        String[] arr1 = new String[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = String.valueOf(arr[i]);
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].equals("(")) {
                stack.push(arr1[i]);
            }
            
            if (arr1[i].equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}