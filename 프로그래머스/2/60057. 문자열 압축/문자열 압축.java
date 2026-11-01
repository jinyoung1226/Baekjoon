import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;
            String end = "";
            
            for (int j = i; j < s.length(); j+=i) {
                if ((j+i) > s.length()) {
                    end = s.substring(j);
                    break;
                }
                
                String str = s.substring(j, j + i);
                
                if (prev.equals(str)) {
                    count++;
                } else {
                    if (count != 1) {
                        sb.append(count);
                        sb.append(prev);
                        count = 1;
                        prev = str;
                    } else {
                        sb.append(prev);
                        prev = str;
                    }
                }
            }
            
            if (count != 1) {
                sb.append(count);
                sb.append(prev);
            } else {
                sb.append(prev);
            }

            sb.append(end);
            
            answer = Math.min(answer, sb.toString().length());
        }
        
        if (answer == Integer.MAX_VALUE) {
            return 1;
        }
        
        return answer;
    }
}