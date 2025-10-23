import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        int[] numberArray = new int[N];
        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(data1[i]);
        }

        int[] sumArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sumArray[i] = sumArray[i - 1] + numberArray[i-1];
        }


        for (int i = 0; i < M; i++) {
            String[] data2 = br.readLine().split(" ");
            int a = Integer.parseInt(data2[0]);
            int b = Integer.parseInt(data2[1]);
            bw.write(sumArray[b] - sumArray[a-1] + "\n");
        }

        bw.flush();
        bw.close();

    }
}