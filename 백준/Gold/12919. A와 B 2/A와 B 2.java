import java.io.*;
import java.util.*;

public class Main {

    static String S,T;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(T);

        DFS(sb);
        System.out.println(result);

    }

    static void DFS(StringBuilder sb) {
        if (sb.length() < S.length()) {
            return;
        }

        if (sb.toString().equals(S)) {
            result = 1;
            return;
        }


        // 방법 1
        if (sb.charAt(sb.length()-1) == 'A') {
            DFS(new StringBuilder(sb).deleteCharAt(sb.length() - 1));
        }

        // 방법 2
        if (sb.charAt(0) == 'B') {
            DFS(new StringBuilder(sb).reverse().deleteCharAt(sb.length() - 1));
        }
    }
}