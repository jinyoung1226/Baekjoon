import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                arr[ch - 'A'] += Math.pow(10, str.length() - 1 - j);
            }
        }
        Arrays.sort(arr);

        int order = 25;
        int turn = 9;
        int result = 0;
        while (arr[order] != 0) {
            result += arr[order] * turn;
            turn--;
            order--;
        }

        System.out.println(result);


    }
}