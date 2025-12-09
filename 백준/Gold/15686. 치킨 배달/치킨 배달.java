import java.io.*;
import java.util.*;

public class Main {


    static int N,M;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String[] data1 = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(data1[j-1]);
            }
        }

        backTracking(0, 1, 1);
        System.out.println(result);
    }

    static void backTracking(int chicken_count, int x_start, int y_start) {
        // 치킨 개수가 M이랑 같을 때 중단 조건
        if (chicken_count == M) {
            int total_length = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 1) {
                        total_length += Search(i, j);
                    }
                }
            }

            result = Math.min(result, total_length);
            return;
        }


        for (int i = x_start; i <= N; i++) {
            int j_start = (i == x_start) ? y_start : 1;
            for (int j = j_start; j <= N; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 3;
                    backTracking(chicken_count + 1, i , j);
                    map[i][j] = 2;
                }
            }
        }
    }

    static int Search(int x, int y) {
        List<Integer> chicken_list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 3) {
                    chicken_list.add(Math.abs(x - i) + Math.abs(y - j));
                }
            }
        }

        Collections.sort(chicken_list);

        return chicken_list.get(0);
    }
}