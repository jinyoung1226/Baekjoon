import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static boolean [][] visited;
    static boolean [][] map;
    static int countDanJi;
    static List<Integer> nums = new ArrayList<>();
    static int num = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(data[j]) == 1) {
                    map[i][j] = true;
                }
            }
        }

        // DFS 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j]) {
                    countDanJi++;
                    DFS(i,j,N);
                    nums.add(num);
                    num = 1;
                }
            }
        }

        System.out.println(countDanJi);
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i)).append("\n");
        }
        System.out.println(sb);

    }

    static void DFS(int x, int y, int N) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if(!visited[newX][newY] && map[newX][newY]) {
                    DFS(newX, newY, N);
                    num++;
                }
            }
        }
    }
}