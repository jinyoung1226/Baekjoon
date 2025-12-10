import java.io.*;
import java.util.*;

public class Main {

    static int N,S;
    static int[] arr;
    static int[] check_arr;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        S = Integer.parseInt(data[1]);

        arr = new int[N];
        check_arr = new int[N];
        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        for (int i = 1; i <= N; i++) {
            backTracking(0, 0, i);
        }

        System.out.println(result);
    }

    static void backTracking(int start, int depth_count, int depth) {
        if (depth_count == depth) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += check_arr[i];
            }

            if (S == count) {
                result += 1;
            }

            return;
        }



        for (int i = start; i < N; i++) {
            check_arr[start] = arr[i];
            backTracking(i+1, depth_count+1, depth);
            check_arr[start] = 0;
        }
    }
}