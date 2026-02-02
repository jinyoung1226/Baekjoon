import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int[] arr;
    static String[] operation = new String[]{" ", "+", "-"};
    static String[] tmpOperation;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            tmpOperation = new String[N-1];

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i+1;
            }

            comb(0);
            System.out.println();


        }


    }

    static void comb(int depth) {
        if (depth == N-1) {
            StringBuilder expr = new StringBuilder();
            expr.append(arr[0]);

            for (int i = 0; i < N - 1; i++) {
                expr.append(tmpOperation[i]).append(arr[i + 1]);
            }

            String str = expr.toString().replace(" ", "");
            List<Character> list = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    list.add(str.charAt(i));
                }
            }

            String[] strArr = str.split("[+-]");

            int total = Integer.parseInt(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                if (list.get(i-1) == '-') {
                    total -= Integer.parseInt(strArr[i]);
                } else {
                    total += Integer.parseInt(strArr[i]);
                }
            }

            if (total == 0) {
                System.out.println(expr);
            }

            return;
        }


        for (int i = 0; i < 3; i++) {
            tmpOperation[depth] = operation[i];
            comb(depth+1);
        }
    }
}