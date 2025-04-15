import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            if(data.contains("push")) {
                String[] data1 = data.split(" ");
                queue.add(Integer.parseInt(data1[1]));
            } else if(data.contains("pop")) {
                if(queue.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(queue.pollFirst() + "\n");
                }
            } else if(data.contains("size")) {
                bw.write(queue.size() + "\n");
            } else if(data.contains("empty")) {
                if(queue.isEmpty()) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else if(data.contains("front")) {
                if(queue.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(queue.getFirst() + "\n");
                }
            } else if(data.contains("back")) {
                if(queue.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(queue.getLast() + "\n");
                }
            }
        }
        bw.flush();
    }
}
