import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x;
        int y;
        int cost;
        int wallNowCount;

        public Node(int x, int y, int cost, int wallNowCount) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.wallNowCount = wallNowCount;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        arr = new int[N][M];
        visited = new boolean[2][N][M]; // 1 벽부심, 0 안부심
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0) {
                        if (!visited[now.wallNowCount][nx][ny]) {
                            visited[now.wallNowCount][nx][ny] = true;
                            q.add(new Node(nx, ny, now.cost+1, now.wallNowCount));
                        }
                    } else {
                        if (now.wallNowCount == 0 && !visited[1][nx][ny]) {
                            visited[1][nx][ny] = true;
                            q.add(new Node(nx, ny, now.cost+1, 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}