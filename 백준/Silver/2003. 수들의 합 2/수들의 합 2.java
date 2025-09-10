import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        arr = new int[N];

        String[] arr_data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arr_data[i]);
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];
        int count = 0;


        while (true) {
            if (sum < M) {
                end++;
                if (end == N) {
                    break;
                }
                sum += arr[end];
            } else {
                if (sum == M) {
                    count++;
                }
                sum -= arr[start];
                start++;
            }
        }

        System.out.println(count);



    }
}
