import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer K;
    static Integer[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);  // 동전 개수
        K = Integer.parseInt(data[1]);  // 가격

        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Greedy(arr, K));
    }

    static int Greedy(Integer[] arr, Integer K) {
        count = 0;

        for (int i = 0; i < N; i++) {
            if (K == 0) {
                break;
            }
            if (arr[i] > K) {
                continue;
            } else {
                count += K/arr[i];
                K = K % arr[i];
            }
        }
        return count;
    }
}