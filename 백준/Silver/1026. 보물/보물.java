import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer[] A_arr;
    static Integer[] B_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A_arr = new Integer[N];
        B_arr = new Integer[N];
        String[] data = br.readLine().split(" ");
        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A_arr[i] = Integer.parseInt(data[i]);
            B_arr[i] = Integer.parseInt(data1[i]);
        }

        Arrays.sort(A_arr); // 오름차순
        Arrays.sort(B_arr, Collections.reverseOrder()); // 내림차순

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A_arr[i] * B_arr[i];
        }

        System.out.println(result);



    }
}