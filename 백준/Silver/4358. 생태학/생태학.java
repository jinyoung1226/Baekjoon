import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<String> list = new ArrayList<>();
    static TreeMap<String, Double> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // O(N)
        String input;
        while ((input = br.readLine()) != null) {
            list.add(input);
        }

        // 해쉬에 <종, 카운트>로 넣기 -> O(N)
        for (String kind : list) {
            map.put(kind, map.getOrDefault(kind, 0.0) + 1);
        }

        // Keyset으로 꺼내서 하나씩 전체 개수로 나눠주기 -> O(N)
        int total = list.size();
        for (String key : map.keySet()) {
            double value = map.get(key) * 100 / total;
            double percent = Math.round(value * 10000) / 10000.0;
            map.put(key, percent);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            sb.append(entry.getKey() + " " + String.format("%.4f\n", entry.getValue()));
        }

        System.out.println(sb.toString());

    }
}