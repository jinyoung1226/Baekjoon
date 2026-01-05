import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] paper;
    static int minusOneCount = 0;
    static int zeroCount = 0;
    static int oneCount = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(data[j]);
            }
        }

        divide(0, 0, N);
        System.out.println(minusOneCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    static void divide(int garo, int sero, int length) {
        int sameCheckNum = paper[garo][sero];
        boolean check = false;
        for (int i = garo; i < garo+length; i++) {
            for (int j = sero; j < sero+length; j++) {
                if (paper[i][j] != sameCheckNum) {
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }

        if (!check) {
            if (sameCheckNum == -1) {
                minusOneCount++;
            } else if (sameCheckNum == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }

        int divide = length / 3;

        divide(garo, sero, divide); // (0,0)
        divide(garo, sero + divide, divide); // (0,3)
        divide(garo, sero + divide*2, divide); // (0,6)

        divide(garo + divide, sero , divide); // (3,0)
        divide(garo + divide, sero + divide , divide); // (3,3)
        divide(garo + divide, sero + divide*2 , divide); // (3,6)

        divide(garo + divide*2, sero , divide); // (6,0)
        divide(garo + divide*2, sero + divide, divide); // (6,3)
        divide(garo + divide*2, sero + divide*2, divide); // (6,6)
    }
}