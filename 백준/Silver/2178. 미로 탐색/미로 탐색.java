import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == N-1 && point.y == M-1) {
                System.out.println(point.dist);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (!visited[newX][newY] && graph[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        queue.add(new Point(newX, newY, point.dist + 1));
                    }
                }
            }
        }
    }
}