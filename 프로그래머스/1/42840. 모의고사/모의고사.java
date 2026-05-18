import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 삼인방 패턴
        int[] one = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (one[i%5] == answers[i]) score[0]++;
            if (second[i%8] == answers[i]) score[1]++;
            if (third[i%10] == answers[i]) score[2]++;
        }

        
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            max = Math.max(max, score[i]);
        }

        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                list.add(i+1);
            }
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}