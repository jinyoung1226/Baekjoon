import java.io.*;
import java.util.*;

public class Main {

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, K, L;
    static int[][] board;
    static HashMap<Integer, String> map = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int time = 0;
    static int nowDirectionIndex = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력받기
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // board 배열 초기화 + 사과 배치 (0은 빈공간, 1은 뱀이 포함된 공간, -1은 사과)
        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            String[] apple = br.readLine().split(" ");
            board[Integer.parseInt(apple[0])-1][Integer.parseInt(apple[1])-1] = -1;
        }

        // 뱀의 방향 정보 입력 받고 방향 배열(인덱스가 초, 값이 방향)
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] snakeDirection = br.readLine().split(" ");
            map.put(Integer.parseInt(snakeDirection[0]), snakeDirection[1]);
        }

        time = 0; // 몇초 걸리는지 체크하는 변수
        nowDirectionIndex = 0; // 현재 뱀이 바라보는 방향을 가르키는 변수
        Deque<Location> dq = new ArrayDeque<>(); // 현재 뱀의 길이 좌표를 관리하는 덱
        dq.add(new Location(0,0)); // 시작점 (0,0) 먼저 넣고 시작
        board[0][0] = 1; // 보드에도 (0,0)은 시작점이기에 방문으로 처리

        while (true) {
            time++;

            int nowX = dq.peekLast().x;
            int nowY = dq.peekLast().y;

            // 뱀 이동
            int nextX = nowX + dx[nowDirectionIndex];
            int nextY = nowY + dy[nowDirectionIndex];

            // 벽에 막힐 경우
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                break;
            }

            // 자기 몸에 막힐 경우
            if (board[nextX][nextY] == 1) {
                break;
            }

            // 사과 있을 때 없을 때 처리
            visitCal(dq, nextX, nextY);

            // 방향 바꾸기
            if (map.containsKey(time)) {
                String direction = map.get(time);
                if (direction.equals("D")) {
                    nowDirectionIndex = (nowDirectionIndex + 1) % 4;
                } else {
                    nowDirectionIndex = (nowDirectionIndex + 3) % 4;
                }
            }
        }
        System.out.println(time);
    }

    static void visitCal(Deque<Location> dq, int nextX, int nextY) {
        // 방문하는 곳이 사과가 있는 경우
        if (board[nextX][nextY] == -1) {
            board[nextX][nextY] = 1;
            dq.addLast(new Location(nextX, nextY));
        } else { // 방문하는 곳이 아무것도 없을 경우
            board[nextX][nextY] = 1;
            dq.addLast(new Location(nextX, nextY));
            Location location = dq.pollFirst();
            board[location.x][location.y] = 0;
        }
    }
}