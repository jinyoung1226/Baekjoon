import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder before = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(alphabet[i], i);
        }
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                result.append(ch);
            } else {
                before.append(ch);
                if (map.containsKey(before.toString())) {
                    result.append(map.get(before.toString()));
                    before = new StringBuilder();
                }
            }
        }
        
        return Integer.valueOf(result.toString());
    }
}