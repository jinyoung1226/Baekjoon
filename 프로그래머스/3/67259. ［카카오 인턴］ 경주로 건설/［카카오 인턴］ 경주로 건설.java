import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    
    public int solution(int[][] board) {
        int N = board.length;
        
        // minCost[x][y][direction]: (x, y) 칸에 direction 방향으로 도달했을 때의 최소 비용
        // 방향 인덱스 -> 0: 상, 1: 하, 2: 좌, 3: 우
        int[][][] minCost = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }
        
        // PriorityQueue: [x, y, cost, direction_index]
        // 오름차순 정렬 (비용이 적은 순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        
        // 시작점에서 이동 가능한 방향으로 초기 설정 (문자열 대신 인덱스 0~3 사용)
        if (board[0][1] == 0) {
            pq.add(new int[]{0, 1, 100, 3}); // 우측 이동 (인덱스 3)
            minCost[0][1][3] = 100;
        }
        if (board[1][0] == 0) {
            pq.add(new int[]{1, 0, 100, 1}); // 하단 이동 (인덱스 1)
            minCost[1][0][1] = 100;
        }
        
        int result = Integer.MAX_VALUE;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCost = now[2];
            int nowDir = now[3]; // 현재 들어온 방향 (0:상, 1:하, 2:좌, 3:우)
            
            // 목적지에 도달하면 최솟값 갱신 후 종료 (PQ이므로 처음 만난 최솟값이 곧 정답)
            if (nowX == N - 1 && nowY == N - 1) {
                result = nowCost;
                break;
            }
            
            // 현재 꺼낸 비용이 이미 기록된 최소 비용보다 크다면 스킵 (가지치기)
            if (nowCost > minCost[nowX][nowY][nowDir]) continue;
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                // 범위 내에 있고 벽이 아닌 경우
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && board[nextX][nextY] == 0) {
                    
                    // 비용 계산 (현재 방향과 다음 방향이 같으면 100원, 다르면 코너 500원 + 직선 100원 = 600원)
                    int nextCost = nowCost + 100;
                    if (nowDir != i) {
                        nextCost += 500;
                    }
                    
                    // 중요: '다음 칸의 해당 방향 최소 비용'보다 현재 계산한 비용이 더 적을 때만 갱신하고 큐에 삽입
                    if (nextCost < minCost[nextX][nextY][i]) {
                        minCost[nextX][nextY][i] = nextCost;
                        pq.add(new int[]{nextX, nextY, nextCost, i});
                    }
                }
            }
        }
        
        return result;
    }
}