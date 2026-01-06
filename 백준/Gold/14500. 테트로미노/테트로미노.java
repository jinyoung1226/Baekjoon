import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int[] tmp_arr_x = new int[5];
    static int[] tmp_arr_y = new int[5];
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] data1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(data1[j]);
            }
        }

        // 완탐 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                tmp_arr_x[0] = i;
                tmp_arr_y[0] = j;
                dfs(i, j, 1);
                tmp_arr_x[0] = 0;
                tmp_arr_y[0] = 0;
                visited[i][j] = false;
            }
        }

        System.out.println(result);

    }

    static void dfs(int x, int y, int depth) {
        if (depth == 4) {
            int total = 0;
            for (int i = 0; i < 4; i++) {
                total += map[tmp_arr_x[i]][tmp_arr_y[i]];
            }

            result = Math.max(result, total);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                if (!visited[newX][newY]) {

                    // 2개를 채웠을 떄, ㅓ ㅏ ㅗ ㅜ 로 예외로 dfs 진행해주기
                    if (depth == 2) {
                        visited[newX][newY] = true;
                        tmp_arr_x[depth] = newX;
                        tmp_arr_y[depth] = newY;
                        dfs(x, y, depth + 1);
                        tmp_arr_x[depth] = 0;
                        tmp_arr_y[depth] = 0;
                        visited[newX][newY] = false;
                    }

                    visited[newX][newY] = true;
                    tmp_arr_x[depth] = newX;
                    tmp_arr_y[depth] = newY;
                    dfs(newX, newY, depth + 1);
                    tmp_arr_x[depth] = 0;
                    tmp_arr_y[depth] = 0;
                    visited[newX][newY] = false;
                }
            }
        }
    }
}