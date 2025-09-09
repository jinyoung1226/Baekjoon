import java.io.*;
import java.security.Principal;

public class Main {
    static int N;
    static int M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int I_x;
    static int I_y;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if (ch == 'I') {
                    I_x = i;
                    I_y = j;
                }
                graph[i][j] = ch;
            }
        }

        DFS(I_x, I_y);
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                if (!visited[newX][newY] && graph[newX][newY] != 'X') {
                    if (graph[newX][newY] == 'P') {
                        result++;
                        DFS(newX, newY);
                    }
                    DFS(newX, newY);
                }
            }
        }
    }


}