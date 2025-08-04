import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        int[] arr = new int[N];

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            end = Math.max(arr[i], end);
        }

        int result = 0;

        while (start <= end) {
            long tree = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    tree = tree + (arr[i] - mid);
                }
            }

            if (tree >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);


    }
}