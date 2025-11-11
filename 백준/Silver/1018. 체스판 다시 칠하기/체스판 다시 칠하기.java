import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                int min = getMin(i, j);
                sol = Math.min(min, sol);
            }
        }

        System.out.println(sol);

    }

    static int getMin(int startRow, int startCol) {
        int count_W = 0;
        int count_B = 0;
        // 1. 맨 처음이 W일 때, 바꾸는 카운팅 세기
        String[] firstWhiteBoard = {"WBWBWBWBWB", "BWBWBWBWBW", "WBWBWBWBWB", "BWBWBWBWBW", "WBWBWBWBWB", "BWBWBWBWBW", "WBWBWBWBWB", "BWBWBWBWBW"};
        int check_row_W = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            int check_col_W = 0;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != firstWhiteBoard[check_row_W].charAt(check_col_W)) {
                    count_W++;
                }
                check_col_W++;
            }
            check_row_W++;
        }
        // 2. 맨 처음이 B일 때, 바꾸는 카운팅 세기
        String[] firstBlackBoard = {"BWBWBWBWBW", "WBWBWBWBWB", "BWBWBWBWBW", "WBWBWBWBWB", "BWBWBWBWBW", "WBWBWBWBWB", "BWBWBWBWBW", "WBWBWBWBWB"};
        int check_row_B = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            int check_col_B = 0;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != firstBlackBoard[check_row_B].charAt(check_col_B)) {
                    count_B++;
                }
                check_col_B++;
            }
            check_row_B++;
        }


        return Math.min(count_W, count_B);
    }
}