import java.io.*;
import java.util.*;

public class Main {

    static class Tomato {
        int z;
        int x;
        int y;
        int dist;

        public Tomato (int z, int x, int y, int dist) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, M, K;
    static int[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        M = Integer.parseInt(data[0]);
        N = Integer.parseInt(data[1]);
        K = Integer.parseInt(data[2]);

        visited = new boolean[K][N][M];

        map = new int[K][N][M];
        for (int z = 0; z < K; z++) {
            for (int x = 0; x < N; x++) {
                String[] data1 = br.readLine().split(" ");
                for (int y = 0; y < M; y++) {
                    map[z][x][y] = Integer.parseInt(data1[y]);
                }
            }
        }
        
        bfs();
    }

    static void bfs() {
        Queue<Tomato> q = new LinkedList<>();
        for (int z = 0; z < K; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[z][x][y] == 1) {
                        q.add(new Tomato(z, x, y, 0));
                        visited[z][x][y] = true;
                    }
                }
            }
        }

        int min = 0;
        while (!q.isEmpty()) {
            Tomato now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int nextZ = now.z + dz[i];

                if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < N && nextY < M && nextZ < K) {
                     if (!visited[nextZ][nextX][nextY] && map[nextZ][nextX][nextY] == 0) {
                        visited[nextZ][nextX][nextY] = true;
                        map[nextZ][nextX][nextY] = 1;
                        q.add(new Tomato(nextZ, nextX, nextY, now.dist + 1));
                        min = Math.max(min, now.dist + 1);
                    }
                }
            }
        }

        boolean flag = false;
        for (int z = 0; z < K; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[z][x][y] == 0) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}