import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(data[0]);
            arr[i][1] = Integer.parseInt(data[1]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                if (a[0] < b[0]) {
                    return -1;
                } else if (a[0] > b[0]) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int result = 0;
        int prev_time = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= prev_time) {
                prev_time = arr[i][1];
                result++;
            }
        }


        System.out.println(result);
    }
}