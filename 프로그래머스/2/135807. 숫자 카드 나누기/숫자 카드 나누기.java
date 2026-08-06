class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int result1 = arrayA[0];
        int result2 = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            result1 = gcd(result1, arrayA[i]);
            result2 = gcd(result2, arrayB[i]);
        }
        
        if (result1 == 1 && result2 == 1) return 0;
        
        if (result1 != 1 && result2 == 1) {
            boolean flag = true;
            for (int i = 0; i < arrayB.length; i++) {
                if (arrayB[i] % result1 == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return result1;
            } else {
                return 0;
            }
        }
        
        if (result1 == 1 && result2 != 1) {
            boolean flag = true;
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % result2 == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return result2;
            } else {
                return 0;
            }
        }
        
        if (result1 != 1 && result2 != 1) {
            int result = 0;
            boolean flag = true;
            for (int i = 0; i < arrayB.length; i++) {
                if (arrayB[i] % result1 == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                result = result1;
            }
            
            
            boolean flag1 = true;
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % result2 == 0) {
                    flag1 = false;
                    break;
                }
            }
            
            if (flag1) {
                result = Math.max(result, result2); 
            }
            
            return result;
        }
        
        return 0;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}