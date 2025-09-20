import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[] cum_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        arr = new int[N];
        cum_arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        // 누적합 배열 생성
        for (int i = 1; i < N+1; i++) {
            cum_arr[i] = cum_arr[i-1] + arr[i-1];
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);

            int sum = cum_arr[end] - cum_arr[start - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);


    }
}