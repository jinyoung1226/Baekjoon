import java.util.*;

class Solution {
    HashSet<String>[] arr;
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        arr = new HashSet[colLen + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HashSet<>();
        }
        
        for (int i = 0; i < colLen; i++) {
            List<Integer> list = new ArrayList<>();
            dfs(relation, 0, i+1, 0, list);
        }
        
        for (int i = 1; i < relation[0].length; i++) {
            for (int j = i+1; j < relation[0].length + 1; j++) {
                HashSet<String> firstSet = arr[i];
                HashSet<String> secondSet = arr[j];
                
                for (String a : firstSet) {
                    List<String> toRemove = new ArrayList<>();
                    for (String b : secondSet) {
                        boolean isSubset = true;
                        for (char c : a.toCharArray()) {
                            if (b.indexOf(c) == -1) {
                                isSubset = false;
                                break;
                            }
                        }
                        if (isSubset) toRemove.add(b);
                    }
                    for (String s : toRemove) secondSet.remove(s);
                }
            }
            
            
        }
        
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            answer += arr[i].size();
        }
        
        
        

        return answer;
    }
    
    void dfs(String[][] relation, int depth, int c, int step, List<Integer> list) {
        if (depth == c) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb1 = new StringBuilder();
                for (int j = 0; j < list.size(); j++) {
                    sb1.append(relation[i][list.get(j)]);
                }
                
                set.add(sb1.toString());
            }
            
            if (set.size() == relation.length) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb2.append(list.get(i));
                }
                arr[depth].add(sb2.toString());
            }
            
            
            return;
        }
        
        
        for (int i = step; i < relation[0].length; i++) {
            list.add(i);
            dfs(relation, depth + 1, c, i+1, list);
            list.remove(list.get(list.size() - 1));
        }
    }
}