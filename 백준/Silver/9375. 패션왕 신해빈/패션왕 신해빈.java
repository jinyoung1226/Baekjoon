import java.io.*;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] data = br.readLine().split(" ");
                map.put(data[1], map.getOrDefault(data[1], 0) + 1);
            }

            int result = 1;
            for (Integer i : map.values()) {
                result = result * (i+1);
            }

            System.out.println(result - 1);
        }

    }
}