import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String order = br.readLine();

            if(order.contains("push_back")) {
                String[] data = order.split(" ");
                Integer X = Integer.parseInt(data[1]);
                deque.addLast(X);
            } else if (order.contains("push_front")) {
                String[] data = order.split(" ");
                Integer X = Integer.parseInt(data[1]);
                deque.addFirst(X);
            } else if (order.contains("pop_front")) {
                if(deque.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    Integer pollFirst = deque.pollFirst();
                    bw.write(pollFirst + "\n");
                }
            } else if (order.contains("pop_back")) {
                if(deque.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    Integer pollLast = deque.pollLast();
                    bw.write(pollLast + "\n");
                }
            } else if (order.contains("size")) {
                bw.write(deque.size() + "\n");
            } else if (order.contains("empty")) {
                if(deque.isEmpty()) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else if (order.contains("front")) {
                if(deque.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(deque.getFirst() + "\n");
                }
            } else if (order.contains("back")) {
                if(deque.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(deque.getLast() + "\n");
                }
            }
        }

        bw.flush();
    }
}