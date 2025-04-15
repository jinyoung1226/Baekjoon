import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            if(data.length > 1) {
                stack.push(Integer.parseInt(data[1]));
            } else {
                if(Integer.parseInt(data[0]) == 2) {
                    if(stack.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                } else if(Integer.parseInt(data[0]) == 3) {
                    bw.write(stack.size() + "\n");
                } else if(Integer.parseInt(data[0]) == 4) {
                    if(stack.isEmpty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                } else if(Integer.parseInt(data[0]) == 5) {
                    if(stack.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                }
            }
        }
        bw.flush();
    }
}