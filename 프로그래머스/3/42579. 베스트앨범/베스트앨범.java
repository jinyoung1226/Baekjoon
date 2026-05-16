import java.util.*;

class Solution {    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!count.containsKey(genres[i])) count.put(genres[i], plays[i]);
            else count.put(genres[i], count.get(genres[i]) + plays[i]);
        }
        System.out.println(count);
        
        for (int i = 0; i < plays.length; i++) {
            if (!music.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
            } else {
                music.get(genres[i]).put(i, plays[i]);
            }
        }
        System.out.println(music);
        
        List<String> genresKey = new ArrayList<>(count.keySet());
        Collections.sort(genresKey, (o1, o2) -> count.get(o2) - count.get(o1));
        System.out.println(genresKey);
        
        List<Integer> answer = new ArrayList<>();
        for (String key : genresKey) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> plays_key = new ArrayList(map.keySet());
            Collections.sort(plays_key, (o1, o2) -> map.get(o2) - map.get(o1));
            System.out.println(plays_key);
            
            answer.add(plays_key.get(0));
            if (plays_key.size() > 1) {
                answer.add(plays_key.get(1));
            }
        }
        
        System.out.println(answer);
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}