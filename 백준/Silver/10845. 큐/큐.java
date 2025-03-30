import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if(input.contains("push")) {
                String[] s = input.split(" ");
                queue.add(Integer.parseInt(s[1]));
            } else if(input.contains("pop")) {
                if(queue.size() == 0) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else if(input.contains("size")) {
                bw.write(queue.size() + "\n");
            } else if(input.contains("empty")) {
                if(queue.size() == 0) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else if(input.contains("front")) {
                if(queue.size() == 0) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else if(input.contains("back")) {
                if(queue.size() == 0) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(queue.getLast() + "\n");
                }
            }
        }

        bw.flush();
    }
}