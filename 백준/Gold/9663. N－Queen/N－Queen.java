import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new int[N][N];

        backTracking(0);
        System.out.println(result);
    }

    static void backTracking(int row) {

        if (row == N) {
            result++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (visited[row][j] == 0) {
                visited[row][j] += 1;

                // 상 방문 처리
                for (int k = row-1; k >= 0; k--) {
                    visited[k][j] += 1;
                }

                // 하 방문 처리
                for (int k = row+1; k <= N-1; k++) {
                    visited[k][j] += 1;
                }

                // 좌 방문 처리
                for (int k = j-1; k >= 0; k--) {
                    visited[row][k] += 1;
                }

                // 우 방문 처리
                for (int k = j+1; k <= N-1; k++) {
                    visited[row][k] += 1;
                }

                // 좌상 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row-k >= 0 && j-k >= 0) {
                        visited[row-k][j-k] += 1;
                    }
                }

                // 우상 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row-k >= 0 && j+k <= N-1) {
                        visited[row-k][j+k] += 1;
                    }
                }

                // 좌하 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row+k <= N-1 && j-k >= 0) {
                        visited[row+k][j-k] += 1;
                    }
                }

                // 우하 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row+k <= N-1 && j+k <= N-1) {
                        visited[row+k][j+k] += 1;
                    }
                }

                backTracking(row+1);

                visited[row][j] -= 1;

                // 상 방문 처리
                for (int k = row-1; k >= 0; k--) {
                    visited[k][j] -= 1;
                }

                // 하 방문 처리
                for (int k = row+1; k <= N-1; k++) {
                    visited[k][j] -= 1;
                }

                // 좌 방문 처리
                for (int k = j-1; k >= 0; k--) {
                    visited[row][k] -= 1;
                }

                // 우 방문 처리
                for (int k = j+1; k <= N-1; k++) {
                    visited[row][k] -= 1;
                }

                // 좌상 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row-k >= 0 && j-k >= 0) {
                        visited[row-k][j-k] -= 1;
                    }
                }

                // 우상 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row-k >= 0 && j+k <= N-1) {
                        visited[row-k][j+k] -= 1;
                    }
                }

                // 좌하 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row+k <= N-1 && j-k >= 0) {
                        visited[row+k][j-k] -= 1;
                    }
                }

                // 우하 대각선 방문 처리
                for (int k = 1; k <= N-1; k++) {
                    if(row+k <= N-1 && j+k <= N-1) {
                        visited[row+k][j+k] -= 1;
                    }
                }
            }
        }
    }
}