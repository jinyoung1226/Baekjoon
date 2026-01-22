import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int pictureCount = 0;
    static int maxWidth = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        paper = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0 ; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0 ; j < M; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && paper[i][j] == 1) {
                    BFS(i, j);
                    pictureCount++;
                }
            }
        }


        System.out.println(pictureCount);
        if (pictureCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(maxWidth);
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        int pictureWidth = 1;

        while (!q.isEmpty()) {
            int[] XY = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = XY[0] + dx[i];
                int newY = XY[1] + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (!visited[newX][newY] && paper[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        q.add(new int[] {newX, newY});
                        pictureWidth++;
                    }
                }
            }
        }

        maxWidth = Math.max(maxWidth, pictureWidth);
    }
}