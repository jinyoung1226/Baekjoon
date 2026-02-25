import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;
        int time;

        public Node (int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static List<Integer> result = new ArrayList<>();
    static int N, M;
    static int[][] board;
    static List<int[]> list = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 조합으로 2 위치에 M개를 놓을 수 있는 만큼 배치(백트래킹)
        combination(0, 0);
        Collections.sort(result);

        if (result.get(0) == -1 && result.get(result.size()-1) == -1) {
            System.out.println(-1);
        } else {
            if (result.get(0) != -1) {
                System.out.println(result.get(0));
            } else {
                int prev = -1;
                for (int i = 1; i < result.size(); i++) {
                    if (result.get(i) != prev) {
                        System.out.println(result.get(i));
                        break;
                    }
                }
            }
        }


    }

    public static void combination(int start, int depth) {
        if (depth == M) {
            int tmp = BFS();
            result.add(tmp);
            return;
        }

        for (int i = start; i < N*N; i++) {
            int row  = i / N;
            int col  = i % N;
            if (board[row][col] == 2) {
                int[] tmp = {row, col};
                list.add(tmp);
                combination(i+1, depth+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static int BFS() {
        int[][] clone_arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) clone_arr[i][j] = -1;
                else clone_arr[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int[] tmp = list.get(i);
            clone_arr[tmp[0]][tmp[1]] = 3;
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] tmp = list.get(i);
            q.add(new Node(tmp[0], tmp[1], 0));
        }

        int min = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + now.x;
                int nextY = dy[i] + now.y;

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (clone_arr[nextX][nextY] == 0 ||clone_arr[nextX][nextY] == 2) {
                        if (clone_arr[nextX][nextY] == 0) {
                            min = Math.max(min, now.time + 1);
                        }
                        clone_arr[nextX][nextY] = -2;
                        q.add(new Node(nextX, nextY, now.time+1));
                    }
                }
            }
        }

        boolean AllCheck = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clone_arr[i][j] == 0) {
                    AllCheck = false;
                    break;
                }
            }
        }

        if (!AllCheck) {
            return -1;
        } else {
            return min;
        }
    }
}