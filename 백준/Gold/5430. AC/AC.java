import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // T - 100
        // p - 100,000
        // n - 100,000
        // 100 * 100,000 * 100,000
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<String> dq = new ArrayDeque<>();

            if (n > 0) {
                input = input.substring(1, input.length() - 1);
                String[] arr = input.split(",");
                for (String str : arr) {
                    dq.add(str);
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }

                    if (reverse) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            if (error) {
                continue;
            }

            sb.append("[");
            int dq_size = dq.size();
            for (int i = 0; i < dq_size; i++) {
                if (reverse) {
                    sb.append(dq.pollLast());
                } else {
                    sb.append(dq.pollFirst());
                }
                if (i != dq_size - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);

        }

    }
}