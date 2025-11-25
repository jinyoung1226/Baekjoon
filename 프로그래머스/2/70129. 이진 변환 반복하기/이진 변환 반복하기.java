class Solution {
    static StringBuilder sb;
    static int count = 0;
    static int delete_0_count = 0;
    
    public int[] solution(String s) {
        sb = new StringBuilder(s);
        
        BinaryChange(sb);
        
        int[] arr = {count, delete_0_count};
        return arr;
    }
    
    public void BinaryChange(StringBuilder sb) {
        while (!sb.toString().equals("1")) {
            char[] char_arr = sb.toString().toCharArray();
            StringBuilder tmp = new StringBuilder();
        
            for (int i = 0; i < char_arr.length; i++) {
                if (char_arr[i] == '1') {
                    tmp.append(char_arr[i]);
                }
            }
            
            delete_0_count += (sb.toString().length() - tmp.toString().length());
            
            String binaryNumber = String.valueOf(Integer.toBinaryString(tmp.length()));
            sb = new StringBuilder(binaryNumber);
            
            count++;
        }
    }
}