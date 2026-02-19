import java.io.*;
import java.util.*;

public class Main {


    static int N;
    static String[][] board;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    // 아래랑 스위치
                    if (k == 0) {
                        if (i == N-1) continue;
                        String first = board[i][j];
                        String second = board[i+1][j];
                        board[i][j] = second;
                        board[i+1][j] = first;
                        calculate(board);
                        board[i][j] = first;
                        board[i+1][j] = second;
                    }

                    // 오른쪽이랑 스위치
                    if (k == 1) {
                        if (j == N-1) continue;
                        String first = board[i][j];
                        String second = board[i][j+1];
                        board[i][j] = second;
                        board[i][j+1] = first;
                        calculate(board);
                        board[i][j] = first;
                        board[i][j+1] = second;
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static void calculate(String[][] board) {
        int max = 1;

        // 모든 행의 개수 체크하기
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j].equals(board[i][j-1])) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        // 모든 열의 개수 체크하기
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[j][i].equals(board[j-1][i])) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        result = Math.max(max, result);
    }
}