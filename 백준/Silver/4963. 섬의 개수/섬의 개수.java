import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int islandCount;
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean flag = true;
        while(flag) {
            String[] data = br.readLine().split(" ");

            if(data[0].equals("0") && data[1].equals("0")) {
                flag = false;
                break;
            }

            islandCount = 0;
            w = Integer.parseInt(data[0]);
            h = Integer.parseInt(data[1]);
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String[] data1 = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(data1[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        islandCount++;
                        DFS(i, j);
                    }
                }
            }

            sb.append(islandCount).append("\n");
        }

        System.out.println(sb);

    }

    static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < h && newY < w) {
                if(!visited[newX][newY] && map[newX][newY] == 1) {
                    DFS(newX, newY);
                }
            }
        }
    }
}