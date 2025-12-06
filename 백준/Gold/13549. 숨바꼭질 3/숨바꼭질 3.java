import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int time;

        public Node (int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    static int N,K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        K = Integer.parseInt(data[1]);

        visited = new boolean[100001];

        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        visited[N] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            visited[now.v] = true;

            // 만약 now.v가 K랑 같다면 최소 값과 비교해서 더 작으면 저장
            if (now.v == K) {
                min = Math.min(now.time, min);
                continue;
            }

            // 방법 1 -> 1초 더하고 -1하기
            if (now.v-1 >= 0  && now.v-1 <= 100000 && !visited[now.v-1]) {
                q.add(new Node(now.v-1, now.time + 1));
            }

            // 방법 2 -> 1초 더하고 +1하기
            if (now.v+1 >= 0 && now.v+1 <= 100000 && !visited[now.v+1]) {
                q.add(new Node(now.v+1, now.time + 1));
            }

            // 방법 3 -> 0초 더하고 *2하기
            if (now.v*2 >= 0 && now.v*2 <= 100000 && !visited[now.v*2]) {
                q.add(new Node(now.v*2, now.time));
            }
        }
    }
}