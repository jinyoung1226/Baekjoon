import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int start = 666;
        while(count != N) {
            start++;
            String start_str = String.valueOf(start);
            if (start_str.contains("666")) {
                count++;
            }
         }

        System.out.println(start);
    }
}