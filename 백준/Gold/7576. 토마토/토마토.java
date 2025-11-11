import java.io.*;
import java.util.*;

public class Main {

    static class Tomato {
        int x;
        int y;
        int dist;

        public Tomato(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;

        }
    }

    static int N,M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[1]);
        M = Integer.parseInt(data[0]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row_data = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row_data[j]);
            }
        }

        int min_day = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(min_day);
    }

    static int bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }

        int min_count = 0;

        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = tomato.x + dx[i];
                int newY = tomato.y + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (map[newX][newY] == 0) {
                        map[newX][newY] = 1;
                        queue.add(new Tomato(newX, newY, tomato.dist + 1));
                        min_count = Math.max(min_count, tomato.dist + 1);
                    }
                }
            }
        }

        return min_count;
    }
}