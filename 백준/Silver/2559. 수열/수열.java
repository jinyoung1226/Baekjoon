import java.io.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);

        String[] data1 = br.readLine().split(" ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        int cumulative_sum = 0;

        // 첫 윈도우 보관 O(K)
        for (int i = 0; i < K; i++) {
            cumulative_sum += arr[i];
        }

        int max = cumulative_sum;

        // 새로운거 하나 추가하고 처음꺼 빼주면서, O(N-K) -> O(N)
        for (int i = K; i < N; i++) {
            cumulative_sum += arr[i] - arr[i - K];

            if (max < cumulative_sum) {
                max = cumulative_sum;
            }
        }

        System.out.println(max  );

    }
}