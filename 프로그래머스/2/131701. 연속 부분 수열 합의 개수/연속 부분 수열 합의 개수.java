import java.util.*;
class Solution {
    
    static int count;
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        int length = elements.length;
        
        // 슬라이딩 윈도우
        // i = 0, 1, 2, 3, 4..
        for (int i = 0; i < length; i++) {
            int start = 0;
            int end = start + i;
            
            while (start < length) {
                if (end < length) {
                    int tmp = 0;
                    for (int j = start; j <= end; j++) {
                        tmp += elements[j];
                    }
                    set.add(tmp);

                    start++;
                    end++;
                } else {
                    // end가 기존 배열 범위를 넘어서면 두개로 쪼개서 반복문 진행
                    int tmp = 0;
                    for (int j = start; j <= length-1; j++) {
                        tmp += elements[j];
                    }
                    
                    for (int j = 0; j <= (end % length); j++) {
                        tmp += elements[j];
                    }
                    
                    set.add(tmp);
                    
                    start++;
                    end++;
                }
            }
        }
        
        int result = set.size();
        return result;
    }
}