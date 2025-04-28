import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(data[0]);
            arr[i][1] = Integer.parseInt(data[1]);
        }

        Arrays.sort(arr, (a , b) -> {
            if(a[1] > b[1]) {
                return 1;
            } else if(a[1] < b[1]) {
                return -1;
            } else {
                if(a[0] > b[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
    }
}