import java.io.*;
import java.util.*;

public class Main {

    static boolean[] arr = new boolean[10100];

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 10000; i++) {
            if (arr[i]) {
                continue;
            } else {
                self_number(i);
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }
    }

    static void self_number(int num) {
        int result_num = num;

        while (result_num < 10000) {
            int num1 = result_num;
            for (int i = 0; i < String.valueOf(result_num).length(); i++) {
                if (i == String.valueOf(num1).length() - 1) {
                    num1 += Integer.parseInt(String.valueOf(result_num).substring(i));
                } else {
                    num1 += Integer.parseInt(String.valueOf(result_num).substring(i, i+1));
                }
            }
            
            if (!arr[num1]) {
                arr[num1] = true;
                result_num = num1;
            } else {
                break;
            }
        }
    }
}