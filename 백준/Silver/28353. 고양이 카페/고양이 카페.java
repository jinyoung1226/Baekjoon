import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);

        arr = new int[N];

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        while (start < end) {
            if (arr[start] + arr[end] <= K) {
                count ++;
                start ++;
                end --;
            } else {
                end--;
            }
        }

        System.out.println(count);
    }
}