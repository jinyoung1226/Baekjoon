import java.util.*;

class Solution {
    double[] discountCategory = {0.4, 0.3, 0.2, 0.1};
    int[] discountArr;
    List<int[]> list = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons) {
        discountArr = new int[emoticons.length];
        
        dfs(users, emoticons, discountArr, 0);
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        
            
            
        return list.get(0);
    }
    
    public void dfs(int[][] users, int[] emoticons, int[] discountArr, int depth) {
        if (depth == emoticons.length) {
            int[] result = calculate(users, emoticons, discountArr);
            list.add(result);
            return;
        }
        
        
        for (int i = 0; i < 4; i++) {
            int discountPrice = (int)(discountCategory[i] * (double)emoticons[depth]);
            emoticons[depth] -= discountPrice;
            discountArr[depth] = (int)(discountCategory[i] * (double)100);
            dfs(users, emoticons, discountArr, depth + 1);
            emoticons[depth] += discountPrice;
        }
    }
    
    public int[] calculate(int[][] users, int[] emoticons, int[] discountArr) {
        int[] emoticonsBuyCost = new int[users.length];
        boolean[] emoticonsPlus = new boolean[users.length];
        
        for (int i = 0; i < users.length; i++) {
            int totalCost = 0;
            boolean buyPlus = false;
            for (int j = 0; j < emoticons.length; j++) {
                if (users[i][0] <= discountArr[j]) {
                    totalCost += emoticons[j];
                }
            }
            
            if (totalCost >= users[i][1]) {
                totalCost = 0;
                buyPlus = true;
            }
            
            emoticonsBuyCost[i] = totalCost;
            emoticonsPlus[i] = buyPlus;
        }
        
        int emoticonsPlusCount = 0;
        int totalEmoticonsBuyCost = 0;
        for (int i = 0; i < emoticonsBuyCost.length; i++) {
            if (emoticonsPlus[i]) {
                emoticonsPlusCount++;
            } 
            totalEmoticonsBuyCost += emoticonsBuyCost[i];
        }
        
        
        int[] answer = {emoticonsPlusCount, totalEmoticonsBuyCost};
        return answer;
    }
}