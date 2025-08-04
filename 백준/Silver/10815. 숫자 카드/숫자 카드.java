import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hash = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            hash.put(Integer.parseInt(data[i]), hash.getOrDefault(Integer.parseInt(data[i]), 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] data1 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (hash.containsKey(Integer.parseInt(data1[i]))) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}