import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        int[][] book_minute = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < 2; j++) {
                String time = book_time[i][j];
                String[] split = time.split(":");
                int hour = Integer.valueOf(split[0]) * 60;
                int minute = Integer.valueOf(split[1]);
                int bookMinute = 0;
                if (j == 0) {
                    bookMinute += hour + minute;
                } else {
                    bookMinute += hour + minute + 10;
                }
                book_minute[i][j] = bookMinute;
            }
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.get(1).add(book_minute[0][0]);
        map.get(1).add(book_minute[0][1]);
        System.out.println(map);
        
        int roomId = 2;
        for (int i = 1; i < book_minute.length; i++) {
            boolean possible = false;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                int start = list.get(0);
                int end = list.get(1);
                
                if (book_minute[i][0] >= start && book_minute[i][0] < end) {
                    continue;
                } else {
                    map.get(entry.getKey()).clear();
                    map.get(entry.getKey()).add(book_minute[i][0]);
                    map.get(entry.getKey()).add(book_minute[i][1]);
                    possible = true;
                    break;
                }
            }
            if (!possible) {
                map.put(roomId, new ArrayList<>());
                map.get(roomId).add(book_minute[i][0]);
                map.get(roomId).add(book_minute[i][1]);
                roomId++;
            }
        }
        
        System.out.println(map);
        return map.size();
    }
}