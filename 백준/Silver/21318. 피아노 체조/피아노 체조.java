import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] prefix_sum;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String[] data = br.readLine().split(" ");
        arr = new int[N];
        prefix_sum = new int[N+1];
        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        for (int i = 1; i <= arr.length; i++) {
            if (i == data.length) {
                prefix_sum[i] = prefix_sum[i-1];
                break;
            } else {
                if (arr[i-1] > arr[i]) {
                    prefix_sum[i] = prefix_sum[i-1] + 1;
                } else {
                    prefix_sum[i] = prefix_sum[i-1];
                }
            }
        }
        // [0, 0, 0, 0, 0, 1, 1, 2, 3, 3] 누적합 나온 값 (실수를 누적했을 때)

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int x = Integer.parseInt(data1[0]);
            int y = Integer.parseInt(data1[1]);

            if (x == y) {
                sb.append(0 + "\n");
            } else {
                int sum  = prefix_sum[y-1] - prefix_sum[x-1];
                sb.append(sum + "\n");
            }
        }

        System.out.println(sb);

    }
}
