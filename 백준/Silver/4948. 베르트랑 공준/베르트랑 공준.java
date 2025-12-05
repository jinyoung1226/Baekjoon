import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int n2 = 2 * n;

            for (int i = n+1; i <= n2; i++) {
                boolean flag = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result++;
                }
            }

            System.out.println(result);
            result = 0;
        }

    }
}