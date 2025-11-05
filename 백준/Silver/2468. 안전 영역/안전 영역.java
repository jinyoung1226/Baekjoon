import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int min_height = 1;
    static int max_height = 1;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] row_data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row_data[j]);
                max_height = Math.max(Integer.parseInt(row_data[j]), max_height);
                min_height = Math.min(Integer.parseInt(row_data[j]), min_height);
            }
        }

        for (int i = min_height - 1; i <= max_height; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] <= i) {
                        visited[j][k] = true;
                    }
                }
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }
            visited = new boolean[N][N];
            result = Math.max(cnt, result);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                if (!visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
}