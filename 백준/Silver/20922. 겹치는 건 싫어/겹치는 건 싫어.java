import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);

        int[] arr = new int[N];
        int[] count_arr = new int[100001];

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < data1.length; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        int count = 0;
        int start = 0;
        int end = 0;

        while (end <= arr.length-1) {
            if (count_arr[arr[end]] < K) {
                count_arr[arr[end]] += 1;
                end++;
            } else {
                count_arr[arr[start]] -= 1;
                start++;
            }

            count = Math.max(end-start, count);
        }

        System.out.println(count);


    }
}