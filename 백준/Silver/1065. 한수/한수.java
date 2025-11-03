import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        if (N <= 99) {
            System.out.println(N);
        } else {
            for (int i = 100; i <= N; i++) {
                String str = String.valueOf(i);
                int[] arr = new int[str.length()];

                for (int j = 0; j < str.length(); j++) {
                    arr[j] = str.charAt(j) - '0';
                }

                int dif = arr[0] - arr[1];
                boolean flag = false;
                for (int j = 1; j < arr.length-1; j++) {
                    if ((arr[j] - arr[j+1]) == dif) {
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    continue;
                } else {
                    count++;
                }
            }

            System.out.println(count+99);
        }

    }
}