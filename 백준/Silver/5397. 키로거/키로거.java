import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // <<BP<A>>Cd-

        // 아이디어
        // 스택에 넣고, 화살표 < 가 나오면 임시로 큐에 쌓아놓고, 화살표 >가 나오면 큐에서 다시 빼고 스택으로 넣는다.
        // L <= 1,000,000 이므로 L을 n번 순회하므로 O(N)

        while (T-- > 0) {
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();

            String passwordInput = br.readLine();

            for (char ch : passwordInput.toCharArray()) {
                if (stack1.isEmpty() && ch == '<') continue;

                if (!stack1.isEmpty() && ch == '<') {
                    stack2.add(stack1.pop());
                    continue;
                }

                if (ch == '>') {
                    if (!stack2.isEmpty()) {
                        stack1.add(stack2.pop());
                    }
                    continue;
                }

                if (ch == '-') {
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                    continue;
                }

                if (Character.isLetter(ch) || Character.isDigit(ch)) {
                    stack1.add(String.valueOf(ch));
                }
            }

            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }

            int size = stack1.size();
            String[] arr = new String[size];
            for (int i = size-1; i >= 0; i--) {
                arr[i] = stack1.pop();
            }

            StringBuilder sb = new StringBuilder();
            for (String str : arr) {
                sb.append(str);
            }

            System.out.println(sb);
        }
    }
}