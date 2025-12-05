import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] paper;
    static int blue_count = 0;
    static int white_count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 색종이 세팅
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(data[j]);
            }
        }

        paper_divide(paper, 0, 0, N);
        System.out.println(white_count);
        System.out.println(blue_count);
    }

    static void paper_divide(int[][] paper, int x, int y, int range) {
        // 색종이 크기가 1일 경우 개수 더해주고 return 해주기
        if (range == 1) {
            if (paper[x][y] == 1) {
                blue_count++;
            } else {
                white_count++;
            }
            return;
        }

        // 현재 색종이 범위에서 모든 색이 같은지 체크하는 함수
        int check_number = sameCheck(paper, x, y, range);

        if (check_number == 1) {
            blue_count++;
            return;
        }

        if (check_number == 0) {
            white_count++;
            return;
        }

        int mid = range / 2;

        paper_divide(paper, x, y, mid);
        paper_divide(paper, x, y+mid, mid);
        paper_divide(paper, x+mid, y, mid);
        paper_divide(paper, x+mid, y+mid, mid);
    }

    static int sameCheck(int[][] paper, int x, int y, int range) {
        int first_point = paper[x][y];

        for (int i = x; i < x+range; i++) {
             for (int j = y; j < y+range; j++) {
                 if (first_point != paper[i][j]) {
                     return 2;
                 }
             }
         }

        return first_point;
    }
}