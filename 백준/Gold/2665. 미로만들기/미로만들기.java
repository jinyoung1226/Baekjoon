import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0});
        dist[0][0] = 0;

        while(!dq.isEmpty()) {
            int[] now = dq.poll();

            if (now[0] == n-1 && now[1] == n-1) {
                return dist[n-1][n-1];
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int weight = board[nx][ny];
                    if (weight == 0) weight = 1;
                    else weight = 0;

                    if (dist[nx][ny] > dist[now[0]][now[1]] + weight) {
                        dist[nx][ny] = dist[now[0]][now[1]] + weight;

                        if (weight == 0) {
                            dq.addFirst(new int[]{nx, ny});
                        } else {
                            dq.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }



        if (dist[n-1][n-1] == Integer.MAX_VALUE) {
            return 0;
        } else {
            return dist[n-1][n-1];
        }
    }
}