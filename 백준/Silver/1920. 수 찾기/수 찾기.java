import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        String[] data1 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int checkNum = Integer.parseInt(data1[i]);
            int start = 0;
            int end = arr.length - 1;
            boolean flag = false;

            while(start <= end) {
                int medianIndex = (start + end) / 2;
                int median = arr[medianIndex];

                if (median > checkNum) {
                    end = medianIndex - 1;
                } else if (median < checkNum) {
                    start = medianIndex + 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}