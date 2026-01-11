import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dist;
    static int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++)  {
            String[] data1 = br.readLine().split(" ");
            int start = Integer.parseInt(data1[0]);
            int end = Integer.parseInt(data1[1]);

            if (dist[start][end] != INF) {
                continue;
            }

            dist[start][end] = 1;
            dist[end][start] = 1;
        }

        // 플로이드 워셜 알고리즘 적용
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int min = INF;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                tmp += dist[i][j];
            }

            if (tmp < min) {
                min = tmp;
                index = i;
            }
        }

        System.out.println(index);

    }
}