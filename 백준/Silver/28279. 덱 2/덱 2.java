import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            String[] s = data.split(" ");
            if(s.length > 1) {
                if(s[0].equals("1")) {
                    dq.addFirst(Integer.parseInt(s[1]));
                } else {
                    dq.addLast(Integer.parseInt(s[1]));
                }
            } else {
                if(data.equals("3")) {
                    if(dq.size() != 0) {
                        bw.write(dq.pollFirst() + "\n");
                    } else {
                        bw.write("-1" + "\n");
                    }
                } else if(data.equals("4")) {
                    if(dq.size() != 0) {
                        bw.write(dq.pollLast() + "\n");
                    } else {
                        bw.write("-1" + "\n");
                    }
                } else if(data.equals("5")) {
                    bw.write(dq.size() + "\n");
                } else if(data.equals("6")) {
                    if(dq.size() != 0) {
                        bw.write("0" + "\n");
                    } else {
                        bw.write("1" + "\n");
                    }
                } else if(data.equals("7")) {
                    if(dq.size() != 0) {
                        bw.write(dq.getFirst() + "\n");
                    } else {
                        bw.write("-1" + "\n");
                    }
                } else if(data.equals("8")) {
                    if(dq.size() != 0) {
                        bw.write(dq.getLast() + "\n");
                    } else {
                        bw.write("-1" + "\n");
                    }
                }
            }
            bw.flush();
        }

    }
}