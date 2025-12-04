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

        while (true) {
            if (sb.toString().equals("")) {
                break;
            }
            if (sb.toString().equals(S)) {
                result = 1;
                break;
            }

            if (sb.charAt(sb.length()- 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        System.out.println(result);

    }
}