import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split("");
            Stack<String> parentheses = new Stack<>();

            for (int j = 0; j < data.length; j++) {
                if (data[j].equals("(")) {
                    parentheses.push(data[j]);
                } else {
                    if (!parentheses.isEmpty() && parentheses.peek().equals("(")) {
                        parentheses.pop();
                    } else {
                        parentheses.push(data[j]);
                        break;
                    }
                }
            }

            if (parentheses.isEmpty()) {
                bw.write("YES" + "\n");
                bw.flush();
            } else {
                bw.write("NO" + "\n");
                bw.flush();
            }
        }
    }
}