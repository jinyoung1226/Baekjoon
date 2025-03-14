import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // n까지의 수 입력받기
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int last_number = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if(number > last_number) {
                for(int j = last_number + 1; j <= number; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                last_number = number;
            } else {
                if(stack.peek() != number) {
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
