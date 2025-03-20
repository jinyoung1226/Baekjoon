import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            // 맨 위 카드 버림
            queue.poll();

            // 그 다음 카드를 다시 맨 뒤로 삽입
            Integer poll = queue.poll();
            queue.add(poll);
        }

        bw.write(queue.poll().toString());
        bw.flush();
    }
}