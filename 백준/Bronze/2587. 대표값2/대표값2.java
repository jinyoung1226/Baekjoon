import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int totalSum = 0;
        for (int i = 0; i < 5; i++) {
            totalSum += arr[i];
        }
        bw.write(totalSum/5 + "\n");
        Arrays.sort(arr);
        bw.write(arr[2] + "\n");
        bw.flush();
    }
}