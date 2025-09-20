import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] cum_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        arr = new int[N][M];
        cum_arr = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 2차원 배열 누적합 구하는 공식
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                cum_arr[i][j] = cum_arr[i-1][j] + cum_arr[i][j-1] - cum_arr[i-1][j-1] + arr[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");

            int[] arr = new int[str.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

            int sum = cum_arr[arr[2]][arr[3]] - cum_arr[arr[2]][arr[1]-1] - cum_arr[arr[0]-1][arr[3]] + cum_arr[arr[0]-1][arr[1]-1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}