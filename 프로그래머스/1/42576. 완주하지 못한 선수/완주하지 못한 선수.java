import java.util.*;

class Solution {
    HashMap<String, Integer> nameCount = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        for (int i = 0; i < participant.length; i++) {
            nameCount.put(participant[i], nameCount.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            if (nameCount.containsKey(completion[i])) {
                nameCount.put(completion[i], nameCount.get(completion[i]) - 1);
            }
        }
        
        String exceptionPeople = "";
        
        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() == 1) {
                exceptionPeople = entry.getKey();
            }
        }
        
        return exceptionPeople;
    }
}