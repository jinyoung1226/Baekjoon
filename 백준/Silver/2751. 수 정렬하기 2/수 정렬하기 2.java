import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = N; i > 0; i--) {
            arr[N-i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i : arr) {
            bw.write(i + "\n");
        }
        bw.flush();
    }
}