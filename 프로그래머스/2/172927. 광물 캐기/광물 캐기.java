class Solution {
    int[][] cost = {
        {1,1,1},
        {5,1,1},
        {25,5,1}
    };
    int answer = Integer.MAX_VALUE;
    int mineralsLength;
    String[] mineralsCopy;
    
    public int solution(int[] picks, String[] minerals) {
        mineralsLength = minerals.length;
        mineralsCopy = new String[minerals.length];
        for (int i = 0; i < minerals.length; i++) {
            mineralsCopy[i] = minerals[i];
        }
        dfs(picks, 0, 0);
        
        return answer;
    }
    
    public int mineralIndex(String mineral) {
        if (mineral.equals("diamond")) return 0;
        if (mineral.equals("iron")) return 1;
        return 2;
    }
    
    public void dfs(int[] picks, int mineral, int fatigue) {
        // 종료 조건, 곡괭이가 다 소진됐거나, 광석을 다 캤을 경우
        if (picks[0] + picks[1] + picks[2] == 0 || mineral > mineralsLength - 1) {
            answer = Math.min(answer, fatigue);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;
            
            picks[i]--;
            int sum = 0;
            for (int j = mineral; j < mineral + 5; j++) {
                if (j > mineralsLength - 1) break;
                sum += cost[i][mineralIndex(mineralsCopy[j])];
            }
            
            dfs(picks, mineral + 5, fatigue + sum);
            picks[i]++;
        }
    }
}