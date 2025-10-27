import java.io.*;
import java.util.*;

public class Main {

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] data1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(data1[j]);
            }
        }

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int wall_count) {
        if (wall_count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall_count + 1);
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

        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = virus.x + dx[i];
                int newY = virus.y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (copyMap[newX][newY] == 0) {
                        copyMap[newX][newY] = 2;
                        queue.add(new Virus(newX, newY));
                    }
                }
            }
        }

        int count = 0;

         for (int i = 0; i < N; i++) {
             for (int j = 0; j < M; j++) {
                 if (copyMap[i][j] == 0) {
                     count++;
                 }
             }
         }
         cnt = Math.max(cnt, count);
    }
}