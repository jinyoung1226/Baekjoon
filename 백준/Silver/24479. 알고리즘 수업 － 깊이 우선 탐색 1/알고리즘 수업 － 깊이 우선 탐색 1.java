import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);  // 정점 개수
        int M = Integer.parseInt(data[1]);  // 간선 개수
        int R = Integer.parseInt(data[2]);  // 시작 정점 값

        visited = new int[N + 1];           // 정점의 수보다 +1 만큼 배열 길이 생성(인덱스로 쉽게 조절하기 위해)

        // 인접 리스트에 +1 만큼 리스트 안의 리스트 생성(인덱스로 쉽게 조절하기 위해)
        for (int i = 1; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 개수만큼 반복문을 돌린 후, 인접리스트에 간선 값 삽입
        for(int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int u = Integer.parseInt(data1[0]);
            int v = Integer.parseInt(data1[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접 리스트의 각 간선들을 미리 오름차순으로 정렬하여, 오름차순 순서대로 방문하도록 미리 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;
        DFS(R);

        for(int i = 1; i < N + 1; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb
        );
    }

    static void DFS(int u) {
        visited[u] = count;
        count++;

        for(int v: graph.get(u)) {
            if(visited[v] == 0) {
                DFS(v);
            }
        }
    }
}