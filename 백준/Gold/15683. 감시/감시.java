import java.io.*;
import java.util.*;

public class Main {

    static class CCTV {
        int x;
        int y;
        int cctvKind;

        public CCTV (int x, int y, int cctvKind) {
            this.x = x;
            this.y = y;
            this.cctvKind = cctvKind;
        }
    }

    static int N, M;
    static CCTV[] cctv;
    static int cctv_count;
    static int[][] room_arr;
    static int[][] roomCount_arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M 입력받기
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 사무실 정보 입력받기
        room_arr = new int[N][M];
        roomCount_arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room_arr[i][j] = Integer.parseInt(row[j]);
            }
        }


        // cctv 개수 구하기
        cctv_count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room_arr[i][j] != 0 && room_arr[i][j] != 6) {
                    cctv_count++;
                }
            }
        }


        // 사무실을 순회하면서 cctv 종류 배열 채워주고, roomCount_arr에는 6(벽)일 떄만 -1 넣어주기
        cctv = new CCTV[cctv_count + 1];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room_arr[i][j] != 0 && room_arr[i][j] != 6) {
                    cctv[idx] = new CCTV(i, j, room_arr[i][j]);
                    idx++;
                } else if (room_arr[i][j] == 6) {
                    roomCount_arr[i][j] = -1;
                }
            }
        }

        if (cctv_count == 0) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (room_arr[i][j] == 0) {
                        tmp++;
                    }
                }
            }
            System.out.println(tmp);
        } else {
            DFS(1, 0);
            System.out.println(result);
        }

        // cctv 종류 별로 (x, y, 종류)를 1~8 인덱스까지 배열에 담아야 함
        // dfs로 탐색할 떄 백트래킹을 해줘야 하기 때문에 room_count 2차원 배열을 따로 만들어주고 count를 계쏙해서 해줌(벽은 -1)
        // 이후, cctv 개수만큼 다 돌았으면(Return 조건) room_count 2차원 배열에서 0인 것만 카운트해준다.
        // index 조건을 dfs에 걸어서 1개 증가시켜주면서 cctv 종류 배열에서 하나씩 순서대로 꺼냄
        // cctv 종류 별로 함수 만들기


    }

    static void DFS(int cctvIndex, int depth) {
        // return 조건 (depth가 cctv 개수 마지막꺼 까지 방문했을 경우에 사각지대 체크하고 return)
        if (depth == cctv_count) {
            int notSeeCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (roomCount_arr[i][j] == 0) {
                        notSeeCount++;
                    }
                }
            }

            result = Math.min(result, notSeeCount);
            return;
        }

        CCTV nowCCTV = cctv[cctvIndex];
        int x = nowCCTV.x;
        int y = nowCCTV.y;
        int kind = nowCCTV.cctvKind;

        // 1번 cctv
        if (kind == 1) {
            for (int i = 0; i < 4; i++) {
                // 0이면 오른쪽 행으로
                if (i == 0) {
                    right(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    right(x, y, -1);
                }
                // 1이면 왼쪽 행으로
                if (i == 1) {
                    left(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    left(x, y, -1);
                }
                // 2이면 위쪽 행으로
                if (i == 2) {
                    top(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    top(x, y, -1);
                }
                // 3이면 아래쪽 행으로
                if (i == 3) {
                    down(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    down(x, y, -1);
                }
            }
        }

        // 2번 cctv
        if (kind == 2) {
            for (int i = 0; i < 2; i++) {
                // 0이면 위아래 행으로
                if (i == 0) {
                    top(x, y, 1);
                    down(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    top(x, y, -1);
                    down(x, y, -1);
                }
                // 1이면 왼오른쪽 행으로
                if (i == 1) {
                    left(x, y, 1);
                    right(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    left(x, y, -1);
                    right(x, y, -1);
                }
            }
        }

        // 3번 cctv
        if (kind == 3) {
            for (int i = 0; i < 4; i++) {
                // 0이면 위, 오른쪽 행으로
                if (i == 0) {
                    top(x, y, 1);
                    right(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    top(x, y, -1);
                    right(x, y, -1);
                }
                // 1이면 오른쪽, 아래 행으로
                if (i == 1) {
                    right(x, y, 1);
                    down(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    right(x, y, -1);
                    down(x, y, -1);
                }
                // 2이면 아래, 왼쪽 행으로
                if (i == 2) {
                    down(x, y, 1);
                    left(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    down(x, y, -1);
                    left(x, y, -1);
                }
                // 3이면 왼쪽, 위쪽 행으로
                if (i == 3) {
                    left(x, y, 1);
                    top(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    left(x, y, -1);
                    top(x, y, -1);
                }
            }
        }

        // 4번 cctv
        if (kind == 4) {
            for (int i = 0; i < 4; i++) {
                // 0이면 왼쪽, 위쪽, 오른쪽 행으로
                if (i == 0) {
                    left(x, y, 1);
                    top(x, y, 1);
                    right(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    left(x, y, -1);
                    top(x, y, -1);
                    right(x, y, -1);
                }
                // 1이면 위쪽, 오른쪽, 아래쪽 행으로
                if (i == 1) {
                    top(x, y, 1);
                    right(x, y, 1);
                    down(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    top(x, y, -1);
                    right(x, y, -1);
                    down(x, y, -1);
                }
                // 2이면 오른쪽, 아래쪽, 왼쪽 행으로
                if (i == 2) {
                    right(x, y, 1);
                    down(x, y, 1);
                    left(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    right(x, y, -1);
                    down(x, y, -1);
                    left(x, y, -1);
                }
                // 3이면 아래쪽, 왼쪽, 위쪽 행으로
                if (i == 3) {
                    down(x, y, 1);
                    left(x, y, 1);
                    top(x, y, 1);
                    DFS(cctvIndex+1, depth+1);
                    down(x, y, -1);
                    left(x, y, -1);
                    top(x, y, -1);
                }
            }
        }

        // 5번 cctv
        if (kind == 5) {
            top(x, y, 1);
            right(x, y, 1);
            down(x, y, 1);
            left(x, y, 1);
            DFS(cctvIndex+1, depth+1);
            top(x, y, -1);
            right(x, y, -1);
            down(x, y, -1);
            left(x, y, 1);
        }
    }

    // 오른쪽 행으로 +1 or -1 해주는 함수
    static void right (int x, int y, int operator) {
        for (int i = y; i < M; i++) {
            if (roomCount_arr[x][i] == -1) break;
            roomCount_arr[x][i] += operator;
        }
    }
    // 왼쪽 행으로 +1 or -1 해주는 함수
    static void left (int x, int y, int operator) {
        for (int i = y; i >= 0; i--) {
            if (roomCount_arr[x][i] == -1) break;
            roomCount_arr[x][i] += operator;
        }
    }
    // 위쪽 행으로 +1 or -1 해주는 함수
    static void top (int x, int y, int operator) {
        for (int i = x; i >= 0; i--) {
            if (roomCount_arr[i][y] == -1) break;
            roomCount_arr[i][y] += operator;
        }
    }
    // 아래쪽 행으로 +1 or -1 해주는 함수
    static void down (int x, int y, int operator) {
        for (int i = x; i < N; i++) {
            if (roomCount_arr[i][y] == -1) break;
            roomCount_arr[i][y] += operator;
        }
    }
}