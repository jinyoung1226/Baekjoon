import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        String data;
        int sum;

        public Node (String data, int sum) {
            this.data = data;
            this.sum = sum;
        }
    }

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {

            String input = br.readLine();
            char[] char_arr = input.toCharArray();

            int digit_sum = 0;
            for (int j = 0; j < char_arr.length; j++) {
                if (Character.isDigit(char_arr[j])) {
                    digit_sum += char_arr[j] - '0';
                }
            }

            arr[i] = new Node(input, digit_sum);
        }

        Arrays.sort(arr, (o1, o2) -> {
           if (o1.data.length() != o2.data.length()) {
               return o1.data.length() - o2.data.length();
           } else {
               if (o1.sum != o2.sum) {
                   return o1.sum - o2.sum;
               } else {
                   return o1.data.compareTo(o2.data);
               }
           }
        });

        for (Node node : arr) {
            System.out.println(node.data);
        }
    }
}
