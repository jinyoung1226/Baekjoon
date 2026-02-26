import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] universe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        M = Integer.parseInt(data[0]);
        N = Integer.parseInt(data[1]);

        universe = new int[M][N];

        // 1. 각 우주 번호 압축하기(상대적인 비교값인 rank로) = 값 압축
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int j = 0; j < arr.length; j++) arr[j] = Integer.parseInt(input[j]);
            int[] sorted = arr.clone();

            Arrays.sort(sorted);

            HashMap<Integer, Integer> map = new HashMap<>();

            int rank = 0;
            map.put(sorted[0], 0);

            for (int j = 1; j < N; j++) {
                if (sorted[j] != sorted[j-1]) {
                    rank++;
                    map.put(sorted[j], rank);
                }
            }

            for (int j = 0; j < N; j++) {
                arr[j] = map.get(arr[j]);
            }

            universe[i] = arr;
        }

        // 2. 순서쌍으로 다 비교하기
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                boolean same = true;

                for (int k = 0;  k < N; k++) {
                    if (universe[i][k] != universe[j][k]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}