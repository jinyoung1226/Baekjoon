import java.io.*;

public class Main {

    static boolean [][] visited;
    static boolean [][] map;
    static int countJiRung;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            int M = Integer.parseInt(data[0]);
            int N = Integer.parseInt(data[1]);
            int K = Integer.parseInt(data[2]);


            visited = new boolean[N][M];
            map = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                String[] data1 = br.readLine().split(" ");
                int X = Integer.parseInt(data1[0]);
                int Y = Integer.parseInt(data1[1]);

                map[Y][X] = true;
            }

            for (int j = 0; j < N; j++) {
                for (int l = 0; l < M; l++) {
                    if(!visited[j][l] && map[j][l]) {
                        countJiRung++;
                        DFS(j, l, N, M);
                    }
                }
            }
            System.out.println(countJiRung);
            countJiRung = 0;
        }
    }

    static void DFS(int x, int y, int N, int M) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < M) {
                if(!visited[newX][newY] && map[newX][newY]) {
                    DFS(newX, newY, N, M);
                }
            }
        }
    }
}