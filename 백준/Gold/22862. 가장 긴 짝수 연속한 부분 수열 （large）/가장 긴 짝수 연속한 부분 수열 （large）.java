import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        arr = new int[N];
        String[] row = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }

        int left = 0;
        int oddCount = 0;
        int result = 0;

        for (int right = 0; right < N; right++) {
            if (arr[right] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > M) {
                if (arr[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            int count = (right - left + 1) - oddCount;
            result = Math.max(result, count);
        }

        System.out.println(result);

    }
}