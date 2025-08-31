import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static int[] sum_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sum_arr = new int[N];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(arr);

        for (int i = N-1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            sum_arr[i] = sum;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += sum_arr[i];
        }
        System.out.println(result);

    }
}