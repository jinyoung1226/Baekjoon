import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> book = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        String[] arr = msg.split("");
        int idxNum = 27;
        int temp = 1;
        for (int i = 65; i < 91; i++) {
            String str = String.valueOf((char) i);
            book.put(str, temp);
            temp++;
        }
        
        int idx = 0;
        while (idx <= arr.length-1) {
            String str = arr[idx];
            while (true) {
                if (idx == arr.length - 1) {
                    list.add(book.get(str));
                    break;
                }
                String copy = str;
                copy = copy + arr[idx + 1];
                
                if (book.containsKey(copy)) {
                    str = str + arr[idx + 1];
                    idx++;
                } else {
                    list.add(book.get(str));
                    str = str + arr[idx + 1];
                    book.put(str,idxNum++);
                    break;
                }
            }
            
            idx++;
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}