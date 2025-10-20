import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] arr = str.toCharArray();

        int pointer = 0;
        Integer num = 1;

        while (pointer < arr.length) {
            String s = Integer.toString(num);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == arr[pointer]) {
                    pointer++;
                }
                if (pointer >= arr.length) {
                    break;
                }
            }
            num++;
        }

        System.out.println(num-1);
    }
}