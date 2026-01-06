import java.util.*;

class Solution {
    
    static HashSet<String> set = new HashSet<>();
    public int[] solution(int n, String[] words) {
        set.add(words[0]);
        int[] arr = new int[2];
        
        boolean failed = false;
        for (int i = 1; i < words.length; i ++) {
            // 이전 단어의 끝 단어로 말했는지 체크
            if (words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {
                // 탈락하는 사람의 번호 구하기 i = 4
                int peopleNum = (i+1) % n;
                if (peopleNum == 0) {
                    peopleNum = n;
                }
                
                // 탈락하는 사람의 번째 구하기 
                int order = (i+1) / n;
                if ((i+1) % n != 0) {
                    order++;
                }
                
                arr[0] = peopleNum;
                arr[1] = order;
                failed = true;
                break;
            }
            
            // 이미 앞서서 말한 내용인지 체크
            if (set.contains(words[i])) {
                // 탈락하는 사람의 번호 구하기 i = 4
                int peopleNum = (i+1) % n;
                if (peopleNum == 0) {
                    peopleNum = n;
                }
                
                // 탈락하는 사람의 번째 구하기 
                int order = (i+1) / n;
                if ((i+1) % n != 0) {
                    order++;
                }
                
                arr[0] = peopleNum;
                arr[1] = order;
                failed = true;
                break;
            }
            
            set.add(words[i]);
        }
        
        if (!failed) {
            arr[0] = 0;
            arr[1] = 0;
        }
        
        return arr;
    }
}