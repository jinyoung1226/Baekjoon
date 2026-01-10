import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (data[j].equals("Y")) {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = 1000000000;
                }
            }
        }



        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == 2 || dist[i][j] == 1) {
                    tmp++;
                }
            }
            max = Math.max(max, tmp);
        }

        System.out.println(max);
    }
}