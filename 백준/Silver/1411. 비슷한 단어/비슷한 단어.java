import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] arr;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            String input = br.readLine();
            arr[i] = input;
            list.add(pattern(arr[i]));
        }

        // comb
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
        }
        System.out.println(count);


    }

    static String pattern(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (char chr : word.toCharArray()) {
            if (!map.containsKey(chr)) {
                map.put(chr, idx);
                idx++;
            }
            sb.append(map.get(chr));
        }

        return sb.toString();
    }
}