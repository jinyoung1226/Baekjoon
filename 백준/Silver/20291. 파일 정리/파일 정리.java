import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String,Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("\\.");
            String extendName = str[1];

            map.put(extendName, map.getOrDefault(extendName, 0) + 1);
            set.add(str[1]);
        }


        for (String s :set) {
            list.add(s);
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String extend : list) {
            sb.append(extend);
            sb.append(" ");
            sb.append(map.get(extend));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}