import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String>[] arr = new ArrayList[files.length];
        String[] result = new String[files.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            int idx = 0;
            
            char[] temp_arr = new char[files[i].length()];
            int temp_idx = 0;
            for (char ch : files[i].toCharArray()) {
                temp_arr[temp_idx] = ch;
                temp_idx++;
            }
            
            for (int j = 0; j < temp_arr.length; j++) {
                if (Character.isLetter(temp_arr[j]) || temp_arr[j] == '.' || temp_arr[j] == ' ' || temp_arr[j] == '-') {
                    head.append(temp_arr[j]);
                    idx++;
                } else {
                    break;
                }
            }
            
            for (int j = idx; j < temp_arr.length; j++) {
                if (String.valueOf(number).length()<= 4 && Character.isDigit(temp_arr[j])) {
                    number.append(temp_arr[j]);
                    idx++;
                } else {
                    break;
                }
            }
            
            for (int j = idx; j < temp_arr.length; j++) {
                tail.append(temp_arr[j]);
                idx++;
            }
            
            arr[i].add(String.valueOf(i));
            arr[i].add(head.toString());
            arr[i].add(number.toString());
            arr[i].add(tail.toString());
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            int a = o1.get(1).toLowerCase().compareTo(o2.get(1).toLowerCase());
            if (a != 0) return a;
            
            int b = Integer.compare(Integer.parseInt(o1.get(2)), Integer.parseInt(o2.get(2)));
            if (b != 0) return b;
            
            return Integer.compare(Integer.parseInt(o1.get(0)), Integer.parseInt(o2.get(0)));
        });
        
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i].get(1));
            sb.append(arr[i].get(2));
            sb.append(arr[i].get(3));
            result[i] = sb.toString();
        }

        return result;
    }
}