import java.io.*;
import java.util.*;

public class Main {

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }

    static int N,M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row_data = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row_data[j]);
            }
        }

        backTracking(0);
        System.out.println(max);

    }

    static void backTracking(int wall_count) {
        if (wall_count == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backTracking(wall_count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Virus> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Virus(i,j));
                }
            }
        }

        int[][] copy_arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy_arr[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = virus.x + dx[i];
                int newY = virus.y + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (copy_arr[newX][newY] == 0) {
                        copy_arr[newX][newY] = 2;
                        queue.add(new Virus(newX, newY));
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy_arr[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(count, max);
    }
}