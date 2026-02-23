import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] board;
    static int[][] visited;
    static boolean[][] dfsvisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class XYC {
        int x;
        int y;
        int cost;

        public XYC(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }


        int day = 0;
        while (true) {
            visited = new int[N][N]; // 0이면 아무도 못가는 국가, 1-2-3-4...로 늘리면서 연합국 만들기
            int unionNum = 1;

            // bfs로 국경 뚫어주기(boolean에다가 T로 연결될 것)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        bfs(i,j, unionNum);
                        unionNum++;
                    }
                }
            }

            // visited 2차원 배열이 다 0인지 아닌지 체크 -> 0이면 break, 0이 아니면 다시 반복(day++)
            boolean check = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] != 0) {
                        check = true;
                    }
                }
            }


            if (check) day++;
            else break;

            dfsvisited = new boolean[N][N];

            // dfs로 연합국 숫자 바꿔주기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!dfsvisited[i][j] && visited[i][j] != 0) {
                        List<XYC> list = new ArrayList<>();
                        dfs(i,j,list, visited[i][j]);

                        int newUnionSum = 0;
                        for (int k = 0; k < list.size(); k++) {
                            newUnionSum += list.get(k).cost;
                        }

                        int finalUnionSum = newUnionSum / list.size();
                        for (int k = 0; k < list.size(); k++) {
                            board[list.get(k).x][list.get(k).y] = finalUnionSum;
                        }
                    }
                }
            }
        }

        System.out.println(day);
    }

    public static void dfs(int x, int y, List<XYC> list, int sameUnion) {
        dfsvisited[x][y] = true;
        list.add(new XYC(x,y, board[x][y]));

        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if (visited[nextX][nextY] == sameUnion && !dfsvisited[nextX][nextY]) {
                    dfs(nextX, nextY, list, sameUnion);
                }
            }
        }
    }

    public static void bfs(int x, int y, int unionNum) {
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(x, y));

        while (!q.isEmpty()) {
            XY now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + now.x;
                int nextY = dy[i] + now.y;

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (visited[nextX][nextY] == 0) {
                        int checkNum = Math.abs(board[now.x][now.y] - board[nextX][nextY]);
                        if (checkNum >= L && checkNum <= R) {
                            visited[now.x][now.y] = unionNum;
                            visited[nextX][nextY] = unionNum;
                            q.add(new XY(nextX, nextY));
                        }
                    }
                }
            }
        }
    }
}