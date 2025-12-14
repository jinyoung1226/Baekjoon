import java.io.*;
import java.util.*;

public class Main {

    static int L,C;
    static String[] arr;
    static String[] tmp_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        L = Integer.parseInt(data[0]);
        C = Integer.parseInt(data[1]);

        String[] data1 = br.readLine().split(" ");
        arr = new String[C];
        tmp_arr = new String[L];
        for (int i = 0; i < C; i++) {
            arr[i] = data1[i];
        }

        Arrays.sort(arr);

        combination(0,0);
    }

    static void combination(int start, int depth) {
        if (depth == L) {
            check(tmp_arr);
            return;
        }


        for (int i = start; i < C; i++) {
            tmp_arr[depth] = arr[i];
            combination(i+1, depth+1);
        }
    }

    static void check(String[] tmp_arr) {
        StringBuilder sb = new StringBuilder();

        int moCount = 0;
        int jaCount = 0;

        for (int i = 0; i < tmp_arr.length; i++) {
            if (tmp_arr[i].equals("a") || tmp_arr[i].equals("e") || tmp_arr[i].equals("i") || tmp_arr[i].equals("o") || tmp_arr[i].equals("u")) {
                moCount++;
            } else {
                jaCount++;
            }
            sb.append(tmp_arr[i]);
        }

        if (moCount >= 1 && jaCount >= 2) {
            System.out.println(sb);
        }
    }
}