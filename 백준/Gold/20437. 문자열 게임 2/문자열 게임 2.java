import java.io.*;
import java.util.*;

public class Main {

    static int T, K;
    static String W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            List<Integer>[] arr = new ArrayList[26];
            for (int j = 0; j < 26; j++) {
                arr[j] = new ArrayList<>();
            }

            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            for (int j = 0; j < W.length(); j++) {
                arr[W.charAt(j) - 'a'].add(j);
            }
            
            int max_result = 0;
            int min_result = Integer.MAX_VALUE;

            for (int j = 0; j < 26; j++) {
                if (arr[j].size() < K) {
                    continue;
                }

                List<Integer> list = arr[j];
                for (int k = 0; k <= list.size() - K; k++) {
                    int len = list.get(k+K-1) - list.get(k) + 1;
                    min_result = Math.min(min_result, len);
                    max_result = Math.max(max_result, len);
                }
            }

            if (max_result == 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min_result).append(" ").append(max_result).append("\n");
            }
        }
        System.out.println(sb);
    }
}