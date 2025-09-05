import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순

        int result  = 0;
        for (int i = 0; i < N; i++) {
            int sum = arr[i] * (i + 1);
            if (sum > result) {
                result = sum;
            }
        }

        System.out.println(result);




    }
}