import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수와 나누는 수 입력 받기
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        long[] sumArray = new long[N];
        long[] count = new long[M];
        long answer = 0;
        String[] data1 = br.readLine().split(" ");
        int[] array = new int[data1.length];
        for (int i = 0; i < data1.length; i++) {
            array[i] = Integer.parseInt(data1[i]);
        }

        for (int i = 0; i < N; i++) {
            if(i == 0) {
                sumArray[0] = array[i];
            } else {
                sumArray[i] = sumArray[i - 1] + array[i];
            }
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (sumArray[i] % M);
            if(remainder == 0) {
                answer++;
            }
            count[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if(count[i] > 1) {
                answer += (count[i] * (count[i] - 1)) / 2;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}