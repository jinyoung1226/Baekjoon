import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        divide(0, 0, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null) {
                    sb.append(" ");
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void divide(int x, int y, int depth) {
        if (depth == 1) {
            map[x][y] = "*";
            return;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                divide(x + i*(depth/3), y + j*(depth/3), depth/3);
            }
        }
    }
}