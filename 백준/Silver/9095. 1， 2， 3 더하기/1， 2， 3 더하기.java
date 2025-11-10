import java.io.*;
import java.util.*;

public class Main {

    static int[] dp_arr = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp_arr[1] = 1;
        dp_arr[2] = 2;
        dp_arr[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp_arr[i] = dp_arr[i-1] + dp_arr[i-2] + dp_arr[i-3];
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp_arr[num]);
        }


    }
}