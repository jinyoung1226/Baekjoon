import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;
        int cost;

        public Node (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int N,M;
    static int[][] miro;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        M = Integer.parseInt(data[0]);
        N = Integer.parseInt(data[1]);

        miro = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(row[j]);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        BFS01();
        System.out.println(result);
    }

    public static void BFS01() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0,0,0));
        dist[0][0] = 0;

        while(!dq.isEmpty()) {
            Node now = dq.pollFirst();

            if (now.x == N-1 && now.y == M-1) {
                result = now.cost;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + now.x;
                int nextY = dy[i] + now.y;

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (dist[nextX][nextY] > dist[now.x][now.y] + miro[nextX][nextY]) {
                        dist[nextX][nextY] = dist[now.x][now.y] + miro[nextX][nextY];

                        if (miro[nextX][nextY] == 0) {
                            dq.addFirst(new Node(nextX, nextY, now.cost));
                        } else {
                            dq.addLast(new Node(nextX, nextY, now.cost+1));
                        }
                    }
                }
            }
        }
    }
}