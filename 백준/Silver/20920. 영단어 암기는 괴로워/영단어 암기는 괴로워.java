import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() < M) {
                continue;
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }

        Collections.sort(list, (o1, o2) -> {
           if (!map.get(o1).equals(map.get(o2))) {
               return map.get(o2) - map.get(o1);
           }

           if (o1.length() != o2.length()) {
               return o2.length() - o1.length();
           }

            return o1.compareTo(o2);
        });

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();


    }
}