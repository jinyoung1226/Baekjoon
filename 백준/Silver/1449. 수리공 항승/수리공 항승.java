import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        arr = new int[N];
        visited = new boolean[N];


        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < input1.length; i++) {
            arr[i] = Integer.parseInt(input1[i]);
        }

        Arrays.sort(arr);

        int tapeCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                int tmpIdx = i;
                while (Math.abs(arr[tmpIdx] - arr[i]) < L) {
                    visited[tmpIdx] = true;
                    tmpIdx++;

                    if (tmpIdx >= arr.length) {
                        break;
                    }
                }
                tapeCount++;
            }
        }
        System.out.println(tapeCount);
    }
}