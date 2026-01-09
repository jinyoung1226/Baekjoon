import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];


        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(data[j]);
            }
        }

        floyd();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void floyd() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
    }
}
