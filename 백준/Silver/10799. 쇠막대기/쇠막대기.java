import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        stack.push(array[0]);
        int count = 0;

        for (int i = 1; i < array.length; i++) {
            if(array[i].equals(")") && array[i-1].equals(")")) {
                count++;
                stack.pop();
            } else if(array[i].equals(")") && array[i-1].equals("(")) {
                stack.pop();
                count += stack.size();
            } else if(array[i].equals("(")) {
                stack.push(array[i]);
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}