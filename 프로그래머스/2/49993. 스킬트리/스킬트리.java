import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int skill_cnt = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            Queue<String> q = new LinkedList<>();
            HashSet<String> set = new HashSet<>();
            String[] skill_arr = new String[skill_trees[i].length()];
            boolean flag = true;
            
            for (int j = 0; j < skill.length(); j++) {
                q.add(String.valueOf(skill.charAt(j)));
                set.add(String.valueOf(skill.charAt(j)));
            }
            
            for (int j = 0; j < skill_trees[i].length(); j++) {
                skill_arr[j] = String.valueOf(skill_trees[i].charAt(j));
            }
            
            for (int j = 0; j < skill_arr.length; j++) {
                System.out.println(q);
                if (!set.contains(skill_arr[j])) {
                    continue;
                } else {
                    if (q.peek().equals(skill_arr[j])) {
                        String str = q.poll();
                        set.remove(str);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) skill_cnt++;
        }
        
        return skill_cnt;
    }
}