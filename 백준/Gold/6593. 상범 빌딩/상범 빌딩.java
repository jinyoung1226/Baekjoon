import java.io.*;
import java.util.*;

public class Main {

    static int L,R,C;
    static String[][][] building;
    static boolean[][][] visited;
    static int minutes;
    static Node start;

    // 위, 아래, 상, 하, 좌, 우
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    static class Node {
        int z;
        int x;
        int y;
        int minute;

        public Node (int z, int x, int y, int minute) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] buildingInfo = br.readLine().split(" ");
            L = Integer.parseInt(buildingInfo[0]);
            R = Integer.parseInt(buildingInfo[1]);
            C = Integer.parseInt(buildingInfo[2]);

            // 종료 조건
            if (L == 0 && R == 0 && C ==0) {
                break;
            }

            // 빌딩 정보 초기화(3차원 배열)
            building = new String[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] row = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        if (row[k].equals("S")) {
                            start = new Node(i, j, k, 0);
                        }
                        building[i][j][k] = row[k];
                    }
                }
                String[] empty = br.readLine().split("");
            }

            minutes = 0;
            if (BFS(start)) {
                System.out.println("Escaped in " + minutes + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    public static boolean BFS(Node start) {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[L][R][C];

        q.add(start);
        visited[start.z][start.x][start.y] = true;

        boolean findE = false;

        while (!q.isEmpty()) {
            Node now = q.poll();

            // E를 찾았을 경우 종료
            if (building[now.z][now.x][now.y].equals("E")) {
                findE = true;
                minutes = now.minute;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nextZ = dz[i] + now.z;
                int nextX = dx[i] + now.x;
                int nextY = dy[i] + now.y;

                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && nextZ >= 0 && nextZ < L) {
                    if (!building[nextZ][nextX][nextY].equals("#")) {
                        if (!visited[nextZ][nextX][nextY]) {
                            visited[nextZ][nextX][nextY] = true;
                            q.add(new Node(nextZ, nextX, nextY, now.minute+1));
                        }
                    }
                }
            }
        }
        return findE;
    }
}