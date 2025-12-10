import java.io.*;
import java.util.*;

public class Main {

    static class Knight {
        int x;
        int y;
        int dist;

        public Knight(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int T, I;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];

            String[] current = br.readLine().split(" ");
            String[] future = br.readLine().split(" ");

            System.out.println(BFS(current, future));

        }


    }

    static int BFS(String[] current, String[] future) {
        Queue<Knight> q = new LinkedList<>();
        int current_x = Integer.parseInt(current[0]);
        int current_y = Integer.parseInt(current[1]);
        int future_x = Integer.parseInt(future[0]);
        int future_y = Integer.parseInt(future[1]);

        q.add(new Knight(current_x, current_y, 0));
        visited[current_x][current_y] = true;

        int dist = 0;
        while (!q.isEmpty()) {
            Knight now = q.poll();

            if (now.x == future_x && now.y == future_y) {
                dist = now.dist;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if (newX >= 0 && newX < I && newY >= 0 && newY < I) {
                    if (!visited[newX][newY]) {
                        q.add(new Knight(newX, newY, now.dist + 1));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return dist;
    }
}