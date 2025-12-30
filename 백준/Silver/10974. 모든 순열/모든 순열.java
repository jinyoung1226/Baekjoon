import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] tmp_arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp_arr = new int[N];
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            arr[i-1] = i;
        }

        comb(0);
    }

    static void comb(int depth) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int i : tmp_arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp_arr[depth] = arr[i];
                comb(depth + 1);
                visited[i] = false;
            }
        }
    }
}