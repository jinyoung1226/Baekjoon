import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] tmp_arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        arr = new int[N];
        tmp_arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        backTracking(0);
        System.out.println(result);
    }

    static void backTracking(int depth) {
        if (depth == N) {
            int tmp = 0;
            for (int i = 0; i < N-1; i++) {
                tmp += Math.abs(tmp_arr[i] - tmp_arr[i+1]);
            }
            result = Math.max(tmp, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                tmp_arr[i] = arr[depth];
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}