import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int normal_minute = fees[0];
        int normal_fee    = fees[1];
        int unit_minute   = fees[2];
        int unit_fee      = fees[3];
        HashMap<String, List<Integer>> calculate_map = new HashMap<>();
        TreeMap<String, Integer> cumlative_map = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < records.length; i++) {
            String hour = records[i].substring(0, 2);
            String minute = records[i].substring(3, 5);
            String car_number = records[i].substring(6, 10);
            
            Integer total_minute = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
            if (!calculate_map.containsKey(car_number)) {
                calculate_map.put(car_number, new ArrayList<>());
            }
            
            calculate_map.get(car_number).add(total_minute);
        }
        
        System.out.println(calculate_map);
        
        for (Map.Entry<String, List<Integer>> map : calculate_map.entrySet()) {
            int cumlative_fee = calculate_fee(map.getKey(), map.getValue());
            cumlative_map.put(map.getKey(), cumlative_fee);
        }

        System.out.println(cumlative_map);
        
        
        for (Map.Entry<String, Integer> map : cumlative_map.entrySet()) {
            if (map.getValue() <= normal_minute) {
                result.add(normal_fee);
            } else {
                double temp = (double)(map.getValue() - normal_minute) / (double)unit_minute;
                if (temp % 2 != 0) {
                    int temp1 = (int)Math.ceil(temp);
                    result.add(normal_fee + (temp1 * unit_fee));
                } else {
                    result.add(normal_fee + ((int)temp * unit_fee));
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public int calculate_fee (String car, List<Integer> list) {
        int cumlative_fee = 0;
        
        if (list.size() % 2 == 0) {
            for (int i = 1; i < list.size(); i += 2) {
                cumlative_fee += list.get(i) - list.get(i-1);        
            }
        } else {
            for (int i = 0; i < list.size(); i += 2) {
                if (i == list.size() - 1) {
                    cumlative_fee += 1439 - list.get(i);
                } else {
                    cumlative_fee += list.get(i+1) - list.get(i);
                }
            }
        }
        
        return cumlative_fee;
    }
}