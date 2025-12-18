import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;
    static int[] tmp_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        arr = new int[N];
        tmp_arr = new int[M];

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < data1.length; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        Arrays.sort(arr);

        comb(0,0);
    }

    static void comb(int start, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(tmp_arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }


        for (int i = start; i < N; i++) {
            tmp_arr[depth] = arr[i];
            comb(i+1, depth+1);
        }
    }
}