class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        
        for (int i = 3; i <= (brown+yellow); i++) {
            if ((brown+yellow) % i == 0) {
                int width = (brown + yellow) / i;
                if (width >= i) {
                    if ((width - 2) * (i - 2) == yellow) {
                        result[0] = width;
                        result[1] = i;
                    }
                }
            }
        }
        
        return result;
    }
}