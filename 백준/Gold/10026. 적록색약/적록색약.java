import java.io.*;


public class Main {

    static int N;
    static String[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int normal_count = 0;
    static int unnormal_count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = data[j];
            }
        }

        // 색맹이 아닌 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    String color = graph[i][j];
                    normal_dfs(i, j, color);
                    normal_count++;
                }
            }
        }
        visited = new boolean[N][N];

        // 색맹인 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    String color = graph[i][j];
                    unnormal_dfs(i, j, color);
                    unnormal_count++;
                }
            }
        }
        System.out.println(normal_count + " " + unnormal_count);

    }

    static void normal_dfs(int i, int j, String color) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if (!visited[newX][newY] && graph[newX][newY].equals(color)) {
                    normal_dfs(newX, newY, graph[newX][newY]);
                }
            }
        }
    }

    static void unnormal_dfs(int i, int j, String color) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if (color.equals("R") || color.equals("G")) {
                    if (!visited[newX][newY] && (graph[newX][newY].equals("R") || graph[newX][newY].equals("G"))) {
                        unnormal_dfs(newX, newY, graph[newX][newY]);
                    }
                } else {
                    if (!visited[newX][newY] && graph[newX][newY].equals("B")) {
                        unnormal_dfs(newX, newY, graph[newX][newY]);
                    }
                }
            }
        }
    }
}
