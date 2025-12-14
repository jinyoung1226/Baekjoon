import java.io.*;
import java.util.*;

public class Main {

    static int N,M,r,c,d;
    static int[][] map;
    static int count = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        String[] data1 = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        r = Integer.parseInt(data1[0]);
        c = Integer.parseInt(data1[1]);
        d = Integer.parseInt(data1[2]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] data2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(data2[j]);
            }
        }

        robotClean(r,c,d);
        System.out.println(count);
    }

    static void robotClean(int x, int y, int see) {
        map[x][y] = -1;

        // 주변 4칸 중에 빈칸이 있는 경우 탐색
        for (int i = 0; i < 4; i++) {
            see = (see+3) % 4;

            int newX = x + dx[see];
            int newY = y + dy[see];

            if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                if (map[newX][newY] == 0) {
                    count++;
                    robotClean(newX, newY, see);
                    return;
                }
            }
        }

        // 주변 4칸 중에 빈칸이 없는 경우 탐색
        int b = (see + 2) % 4;
        int bx = x + dx[b];
        int by = y + dy[b];

        if (bx >= 0 && by >= 0 && bx < N && by < M) {
            if (map[bx][by] != 1) {
                robotClean(bx, by, see);
            }
        }
    }
}
