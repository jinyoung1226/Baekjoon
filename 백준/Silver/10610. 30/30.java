import java.io.*;
import java.util.Arrays;

public class Main {
    static char[] arr;
    static char[] arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();
        arr = data.toCharArray();

        Arrays.sort(arr);
        arr1 = new char[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr1[arr.length - i -1] = arr[i];
        }

        int sum = 0;
        String result_char = "";
        for (int i = 0; i < arr1.length; i++) {
            sum += Integer.parseInt(String.valueOf(arr1[i]));
            result_char = result_char.concat(String.valueOf(arr1[i]));
        }

        if (sum % 3 == 0 && result_char.charAt(result_char.length() - 1) == '0') {
            System.out.println(result_char);
        } else {
            System.out.println("-1");
        }

    }
}
