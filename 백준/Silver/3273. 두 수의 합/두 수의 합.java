import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }
        Arrays.sort(arr);

        long x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        while (start < end) {
            if (arr[start] + arr[end] > x) {
                end--;
            } else if (arr[start] + arr[end] < x) {
                start++;
            } else {
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);

    }
}