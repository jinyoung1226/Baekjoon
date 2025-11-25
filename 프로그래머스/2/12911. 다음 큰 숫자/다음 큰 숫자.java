class Solution {
    public int solution(int n) {
        boolean flag = true;
        int result = 0;
        
        String n_binary = Integer.toBinaryString(n);
        int n_count = 0;
        for (int i = 0; i < n_binary.length(); i++) {
            if (n_binary.charAt(i) == '1') {
                n_count++;
            }
        }
        
        n = n+1;
        
        while (flag) {
            int check = 0;
            String binaryNumber = Integer.toBinaryString(n);
            
            for (int i = 0; i < binaryNumber.length(); i++) {
                if (binaryNumber.charAt(i) == '1') {
                    check++;
                }
            }
            
            if (check == n_count) {
                result = n;
                break;
            } else {
                n++;
            }
        }
        
        return result;
    }
}