import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            String command = temp[0];
            String id = temp[1];
            String nickname = "";
            if (temp.length >= 3) {
                nickname = temp[2];
            }
            
            if (command.equals("Enter")) {
                userMap.put(id, nickname);
                list.add(new String[]{id, userMap.get(id), "님이 들어왔습니다."});
            } 
            
            if (command.equals("Leave")) {
                list.add(new String[]{id, userMap.get(id), "님이 나갔습니다."});
            }
            
            if (command.equals("Change")) {
                userMap.put(id, nickname);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            list.get(i)[1] = userMap.get(list.get(i)[0]);
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i)[1] + list.get(i)[2];
        }

        return answer;
    }
}