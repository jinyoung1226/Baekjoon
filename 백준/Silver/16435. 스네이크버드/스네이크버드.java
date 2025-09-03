import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        L = Integer.parseInt(data[1]);

        String[] data1 = br.readLine().split(" ");
        arr = new int[data1.length];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (arr[i] <= L) {
                L++;
            } else {
                break;
            }
        }

        System.out.println(L);
    }
}