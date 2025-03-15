import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            int value = Integer.parseInt(br.readLine());

            if(value != 0) {
                stack.push(value);
            } else {
                stack.pop();
            }
        }

        int total = 0;
        for (Integer i : stack) {
            total += i;
        }
        bw.write(total + "\n");
        bw.flush();
    }
}