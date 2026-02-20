import java.io.*;
import java.util.*;

// 아이디어
// 스택이 비어 있는데 '}'가 나오면 문자를 바꿔주고 스택에 넣어주고 count++
// 스택이 비어 있는데 '{'가 나오면 그대로 스택에 넣어주기
// 스택이 안 비어 있는데 '}'가 나오면 그대로 stack.pop()
// 마지막까지 진행한 후, 스택에 남아 있는게 있으면 남은 수 / 2로 count에 더해주기

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        int testCaseNum = 1;
        while (!(input = br.readLine()).contains("-")) {
            Stack<String> stack = new Stack<>();
            int count = 0;
            String[] data = input.split("");

            for (String str : data) {
                if (stack.isEmpty() && str.equals("}")) {
                    stack.add("{");
                    count++;
                    continue;
                }

                if (stack.isEmpty() && str.equals("{")) {
                    stack.add("{");
                    continue;
                }

                if (!stack.isEmpty() && str.equals("}")) {
                    stack.pop();
                    continue;
                }

                if (!stack.isEmpty() && str.equals("{")) {
                    stack.add("{");
                }
            }

            if (!stack.isEmpty()) {
                int size = stack.size();
                count += size/2;
            }

            System.out.println(testCaseNum + ". " + count);
            testCaseNum++;
        }
    }
}