import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            set.add(elements[i]);
        }
        
        for (int i = 0; i < elements.length-1; i++) {
            int left = 0;
            int right = i+1;
            
            while (left < elements.length) {
                if (left > right) {
                    int sum = 0;
                    for (int j = left; j < elements.length; j++) {
                        sum += elements[j];
                    }
                    for (int j = 0; j <= right; j++) {
                        sum += elements[j];
                    }
                    set.add(sum);
                } else {
                    int sum = 0;
                    for (int j = left; j <= right; j++) {
                        sum += elements[j];
                    }
                    set.add(sum);
                }
                
                left++;
                right = (right+1) % elements.length;
            }
        }
        return set.size();
        
    }
}