import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            int exception_time = cities.length * 5;
            return exception_time;
        }
        
        List<String> list = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        for (String city : cities) {
            // cache hit인 경우
            if (list.contains(city)) {
                int idx = list.indexOf(city);
                list.remove(idx);
                list.add(city);
                time++;
            } else { // cache miss인 경우
                if (list.size() == cacheSize) { // cache miss인 경우에서 캐시가 꽉 찼을 경우
                    list.remove(0);
                    list.add(city);
                } else { // cache miss인 경우에서 캐시가 비어있을 경우
                    list.add(city);
                }
                
                time += 5;
            }
        }
        
        return time;
    }
}