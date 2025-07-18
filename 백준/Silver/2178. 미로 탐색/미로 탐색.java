import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int num;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        num = 0;

        for (int i = 0; i < N; i++) {
            String[] data1 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(data1[j]);
            }
        }

        BFS(0,0);
        System.out.println(map[N - 1][M - 1]);
    }

    static void BFS(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {

            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = map[nowX][nowY] + 1;
                    }
                }
            }
         }

    }

}