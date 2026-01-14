import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // result가 0인 조건 미리 체크
        HashSet<String> discount_set = new HashSet<>(Arrays.asList(discount));
        
        boolean check = false;
        for (String str : want) {
            if (!discount_set.contains(str)) {
                check =true;
                break;
            }
        }
        
        if (check) {
            return 0;
        }
        
        // 슬라이딩 윈도우(end가 배열 index를 넘을 때까지 while문 돌리기)
        int start = 0;
        int end = 9;
        int result = 0; 
        
        while (end <= discount.length - 1) {
            // number 배열 복사
            int[] number_copy = new int[number.length];
            for (int i = 0; i < number.length; i++) {
                number_copy[i] = number[i];
            }
            
            // start ~ end까지 순회해서 만족하는지 파악
            for (int i = start; i <= end; i++) {
                String now = discount[i];
                
                for (int j = 0; j < want.length; j++) {
                    if (want[j].equals(now)) {
                        number_copy[j]--;
                        break;
                    }
                }
            }
            
            boolean check1 = true;
            for (int i : number_copy) {
                if (i != 0) {
                    check1 = false;
                    break;
                }
            }
            
            if (check1) {
                result++;
            }
            
            start++;
            end++;
        }
        
        return result;
    }
}