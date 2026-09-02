import java.util.*;

class Solution {
    char[] operationArr;
    boolean[] visited;
    String[] lastArr;
    long resultRRR = Long.MIN_VALUE;
    public long solution(String expression) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                set.add(expression.charAt(i));
            }
        }
        
        List<Character> list = new ArrayList<>();
        for (Character ch : set) list.add(ch);
        char[] arr = new char[list.size()];
        operationArr = new char[list.size()];
        visited = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        
        StringBuilder sb = new StringBuilder();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
            } else {
                list1.add(sb.toString());
                sb = new StringBuilder();
                list1.add(String.valueOf(expression.charAt(i)));
            }
        }
        
        list1.add(sb.toString());
        lastArr = new String[list1.size()];
        for (int i = 0; i < lastArr.length; i++) {
            lastArr[i] = list1.get(i);
        }
        
        perm(arr, arr.length, 0);
        

        return resultRRR;
    }
    
    public void perm(char[] arr, int k, int n) {
        if (n == k) {
            calculate(operationArr);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                operationArr[n] = arr[i];
                visited[i] = true;
                perm(arr, k, n+1);
                visited[i] = false;
            }
        }
    }
    
    public void calculate(char[] operationArr) {
        String[] lastArrClone = lastArr.clone();
        Stack<String> stack1 = new Stack<>();
        for (int i = lastArrClone.length - 1; i >= 0; i--) {
            stack1.push(lastArrClone[i]);
        }
        
        for (int i = 0; i < operationArr.length; i++) {
            Stack<String> stack2 = new Stack<>();
            
            while (!stack1.isEmpty()) {
                if (!stack1.peek().equals("+") && !stack1.peek().equals("-") && !stack1.peek().equals("*")) {
                    stack2.push(stack1.pop());
                    continue;
                } 
                
                if (String.valueOf(operationArr[i]).equals(stack1.peek())) {
                    stack1.pop();
                    String front = stack2.pop();
                    String rear = stack1.pop();
                    long result = 0;
                    if (operationArr[i] == '-') {
                        result = Long.parseLong(front) - Long.parseLong(rear);
                    } else if (operationArr[i] == '+') {
                        result = Long.parseLong(front) + Long.parseLong(rear);
                    } else {
                        result = Long.parseLong(front) * Long.parseLong(rear);
                    }
                    stack2.push(String.valueOf(result));
                } else {
                    stack2.push(stack1.pop());
                    stack2.push(stack1.pop());
                } 
            }
            
            if (i == operationArr.length - 1) {
                long result = Math.abs(Long.parseLong(stack2.pop()));
                resultRRR = Math.max(resultRRR, result);
                break;
                
            }
            
            String[] strArr = new String[stack2.size()];
            for (int j = strArr.length - 1; j >= 0; j--) {
                strArr[j] = stack2.pop();
            }
            
            for (int j = strArr.length - 1; j >= 0; j--) {
                stack1.push(strArr[j]);
            }
        }
    }
}