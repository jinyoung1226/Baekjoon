import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 표의 크기 N과 합 구하는 횟수 M 입력 받기
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        // 기본 배열과 누적합 배열 구성
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp  = new int[N + 1][N + 1];

        // 표에 N의 크기에 맞게 입력받기 (기본 2차원 배열 만들기)
        for (int i = 1; i <= N; i++) {
            String[] data1 = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(data1[j - 1]);
            }
        }

        // 기본 2차원 배열을 활용해 누적합 2차원 배열 만들기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];
            }
        }

        // 누적합 배열에서 원하는 범위 구하기
        for (int i = 1; i <= M; i++) {
            String[] data2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(data2[0]);
            int y1 = Integer.parseInt(data2[1]);
            int x2 = Integer.parseInt(data2[2]);
            int y2 = Integer.parseInt(data2[3]);
            int answer = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}