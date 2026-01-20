import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int[] arr;
    static int[] tmp_arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = br.readLine().split(" ");
            if (data[0].equals("0")) {
                return;
            }

            k = Integer.parseInt(data[0]);
            arr = new int[k];
            tmp_arr = new int[6];
            for (int i = 1; i <= arr.length; i++) {
                arr[i-1] = Integer.parseInt(data[i]);
            }

            comb(0, 0);
            System.out.println();
        }
    }

    static void comb(int start, int depth) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp_arr.length; i++) {
                sb.append(tmp_arr[i] + " ");
            }

            System.out.println(sb);
            return;
        }


        for (int i = start; i < k; i++) {
            tmp_arr[depth] = arr[i];
            comb(i+1, depth + 1);
        }
    }
}