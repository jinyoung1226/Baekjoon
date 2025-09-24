import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] arr;
    static int[] cum_arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int X = Integer.parseInt(data[1]);

        arr = new int[N];
        cum_arr = new int[N+1];

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        for (int i = 1; i <= N; i++) {
            cum_arr[i] = cum_arr[i-1] + arr[i-1];
        }

        for (int i = 1; i < N; i++) {
            if ((i+X) > cum_arr.length) {
                break;
            }
            int sum = cum_arr[i+X-1] - cum_arr[i-1];
            list.add(sum);
        }

        int max_visitor = 0;
        for (Integer i : list) {
            if (i > max_visitor) {
                max_visitor = i;
            }
        }

        if (max_visitor == 0) {
            System.out.println("SAD");
            return;
        } else {
            System.out.println(max_visitor);
        }

        int count = 0;
        for (Integer i : list) {
            if (i == max_visitor) {
                count++;
            }
        }

        System.out.println(count);
    }
}
