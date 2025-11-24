import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] input_arr = s.split(" ", -1);
        
        for (int i = 0; i < input_arr.length; i++) {
            String tmp = input_arr[i];
            char[] char_arr = tmp.toCharArray();
            
            for (int j = 0; j < char_arr.length; j++) {
                if (j == 0) { // 첫 번째 자리의 경우
                    if (Character.isDigit(char_arr[j])) {
                        sb.append(char_arr[j]); // 맨 첫자리가 숫자인 경우
                    } else {
                        sb.append(Character.toUpperCase(char_arr[j])); // 맨 첫자리가 문자인 경우
                    }
                } else { // 첫 번째 자리를 제외한 경우
                    sb.append(Character.toLowerCase(char_arr[j]));
                }
            }
            if (i != input_arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}