import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split("");

        boolean check = false;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].equals("<")) {
                if (stack.size() > 0) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(arr[i]);
                check = true;
                continue;

            } else if (arr[i].equals(">")) {
                sb.append(arr[i]);
                check = false;
                continue;
            }

            if (check) {
                sb.append(arr[i]);
            } else {
                if (arr[i].equals(" ")) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(arr[i]);
                } else {
                    stack.push(arr[i]);
                }
            }

            if (i == arr.length-1) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}