import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        int[] result = new int[2];
        int flag = arr[0];
        result[flag] += 1;

        for (int i = 1; i < arr.length; i++) {
            if (flag != arr[i]) {
                if (flag == 1) {
                    flag = 0;
                    result[0] += 1;
                } else {
                    flag = 1;
                    result[1] += 1;
                }
            }
        }
        System.out.println(Math.min(result[0], result[1]));
    }
}