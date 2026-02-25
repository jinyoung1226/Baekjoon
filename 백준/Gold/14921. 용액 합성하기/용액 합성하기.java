import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        int left = 0;
        int right = N-1;
        int result = Integer.MAX_VALUE;

        while(left != right) {
            int sum = arr[left] + arr[right];

            if (sum < 0) {
                left++;
            } else {
                right--;
            }

            if(Math.abs(sum) <= Math.abs(result)) {
                result = sum;
            }
        }
        System.out.println(result);

    }
}