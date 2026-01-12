import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visited_char = new boolean[26];
    static boolean[][] visited_board;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        board = new char[N][M];
        visited_board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] data1 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = data1[j].charAt(0);
            }
        }
        
        visited_board[0][0] = true;
        visited_char[board[0][0] - 'A'] = true;
        DFS(0,0);
        System.out.println(result);


    }

    static void DFS(int x, int y) {
        int tmp = 0;
        for (int i = 0; i < 26; i++) {
            if (visited_char[i]) {
                tmp ++;
            }
        }
        result = Math.max(result, tmp);

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                if (!visited_board[newX][newY]) {
                    if (!visited_char[board[newX][newY] - 'A']) {
                        visited_board[newX][newY] = true;
                        visited_char[board[newX][newY] - 'A'] = true;
                        DFS(newX, newY);
                        visited_board[newX][newY] = false;
                        visited_char[board[newX][newY] - 'A'] = false;
                    }
                }
            }
        }
    }
}