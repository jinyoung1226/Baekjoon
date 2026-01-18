import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static TreeMap<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            int idx = fileName.indexOf(".");

            String extendName = fileName.substring(idx+1);

            map.put(extendName, map.getOrDefault(extendName, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {
            sb.append(key + " " + map.get(key) +"\n");
        }

        System.out.println(sb);

    }
}