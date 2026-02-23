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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // M이 0일 경우에 0으로 쳐내기
        if (M == 0) {
            System.out.println(0);
            return;
        }

        // O(nlogn) = 1,500,000 약
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (end < arr.length) {
            int diff = Math.abs(arr[start] - arr[end]);
            if (diff >= M) {
                min = Math.min(min, diff);
                start++;
            } else {
                end++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }

    }
}