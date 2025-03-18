import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        Stack<Integer> stack = new Stack<>();

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
                Integer pop = stack.pop();
                result[pop] = array[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i : result) {
            bw.write(i + "\n");
        }
        bw.flush();
    }
}