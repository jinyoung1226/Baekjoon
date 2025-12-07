import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        K = Integer.parseInt(data[0]);
        N = Integer.parseInt(data[1]);

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(SearchMax(arr));
    }

    static long SearchMax(long[] arr) {

        long left = 1;
        long right = arr[arr.length - 1];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long l : arr) {
                count += l / mid;
            }


            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
