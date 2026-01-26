import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static int[] vacation;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N,M 입력 받기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 도시별로 연결을 관리하는 인접 리스트 초기화
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 인접리스트에 값 추가
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(row[j]) == 1) {
                    graph[i+1].add(j+1);
                }
            }
        }


        // 여행 계획 배열 만들기
        String[] vacationInput = br.readLine().split(" ");
        vacation = new int[vacationInput.length];
        for (int i = 0 ; i < vacationInput.length; i++) {
            vacation[i] = Integer.parseInt(vacationInput[i]);
        }

        // bfs를 여행 계획 2개씩 쪼개서 가는지 확인
        // bfs로 확인하다가 여행을 못 가는 구조로 판별
        boolean possibleVacation = true;
        for (int i = 0; i < vacation.length-1; i++) {
            if (!BFS(vacation[i], vacation[i+1])) {
                possibleVacation = false;
                break;
            }
        }

        if (possibleVacation) System.out.println("YES");
        else System.out.println("NO");

    }

    static boolean BFS(int nowIsland, int nextIsland) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        visited[nowIsland] = true;
        q.add(nowIsland);

        boolean checkPossibleNextIsland = false;

        while(!q.isEmpty()) {
            Integer now = q.poll();

            if (now == nextIsland) {
                checkPossibleNextIsland = true;
                break;
            }

            for (Integer next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return checkPossibleNextIsland;

    }
}