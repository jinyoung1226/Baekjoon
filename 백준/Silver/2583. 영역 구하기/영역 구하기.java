import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int widthCount;
    static List<Integer> result = new ArrayList<>();
    static int M;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        M = Integer.parseInt(data[0]);
        N = Integer.parseInt(data[1]);
        int K = Integer.parseInt(data[2]);

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            String[] data1 = br.readLine().split(" ");
            int x1 = Integer.parseInt(data1[0]);
            int y1 = Integer.parseInt(data1[1]);
            int x2 = Integer.parseInt(data1[2]);
            int y2 = Integer.parseInt(data1[3]);

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && board[i][j] == 0) {
                    count++;
                    widthCount = 0;
                    dfs(i, j);
                    result.add(widthCount);
                }
            }
        }

        Collections.sort(result);

        sb.append(count).append("\n");

        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                sb.append(result.get(i));
            }else {
                sb.append(result.get(i)).append(" ");
            }
        }

        System.out.println(sb);

    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        widthCount++;

        for (int h = 0; h < 4; h++) {
            int newX = i + dx[h];
            int newY = j + dy[h];

            if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
                if (!visited[newX][newY] && board[newX][newY] == 0) {
                    dfs(newX, newY);
                }
            }

        }
    }
}