import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }

        while (pq.size() != 1) {
            int start = pq.poll();
            int second = pq.poll();
            result += (start + second);
            pq.add(start + second);
        }

        System.out.println(result);
    }
}