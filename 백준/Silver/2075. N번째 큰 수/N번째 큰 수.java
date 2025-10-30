import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * N];

        int index_count = 0;
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < data.length; j++) {
                arr[index_count] = Integer.parseInt(data[j]);
                index_count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int result_count = 0;
        while(true) {
            if (result_count == N-1) {
                break;
            }

            queue.poll();
            result_count++;
        }
        System.out.println(queue.peek());

    }
}