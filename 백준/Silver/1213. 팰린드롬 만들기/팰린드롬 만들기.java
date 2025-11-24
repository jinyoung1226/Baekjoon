import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] arr = new int[26];
        char[] alpabet_arr = input.toCharArray();

        for (int i = 0; i < alpabet_arr.length; i++) {
            arr[alpabet_arr[i] - 'A']++;
        }

        int odd = 0;
        int oddIndex = -1;
        for (int i = 0; i < arr.length; i++) {
             if (arr[i] % 2 == 1) {
                odd++;
                oddIndex = i;
            }
        }

        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }


        StringBuilder left = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                left.append((char) ('A' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();
        StringBuilder middle = new StringBuilder();
        if (oddIndex != -1) {
            middle.append((char)('A' + oddIndex));
        }

        System.out.println(left.append(middle).append(right));
    }
}