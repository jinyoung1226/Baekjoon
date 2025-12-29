import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        divide(0, N, 0, N, N);
        System.out.println(sb);
    }

    static void divide(int garoStart, int garoEnd, int seroStart, int seroEnd, int depth) {
        // return 조건은 해당 범위의 영역이 전부 같은 색깔이면
        boolean whiteExist = false;
        boolean blackExist = false;

        for (int i = seroStart; i < seroEnd; i++) {
            for (int j = garoStart; j < garoEnd; j++) {
                if (map[i][j] == 0) {
                    whiteExist = true;
                }

                if (map[i][j] == 1) {
                    blackExist = true;
                }
            }
        }

        if (!whiteExist && blackExist) {
            sb.append(1);
            return;
        } else if (!blackExist && whiteExist) {
            sb.append(0);
            return;
        }

        int newDepth = depth / 2;

        sb.append("(");
        // 4개의 재귀가 들어가야 함
        // 왼쪽 위 분할 탐색
        divide(garoStart, garoEnd - newDepth, seroStart, seroEnd - newDepth, newDepth);

        // 오른쪽 위 분할 탐색x
        divide(garoEnd - newDepth, garoEnd , seroStart, seroEnd - newDepth, newDepth);

        // 왼쪽 아래 분할 탐색
        divide(garoStart, garoEnd - newDepth , seroEnd - newDepth, seroEnd, newDepth);

        // 오른쪽 아래 분할 탐색
        divide(garoEnd - newDepth, garoEnd , seroEnd - newDepth, seroEnd, newDepth);

        sb.append(")");
    }
}