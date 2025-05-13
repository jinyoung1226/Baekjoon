import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]); // 노드의 개수
        int M = Integer.parseInt(data[1]); // 에지의 개수

        visited = new boolean[N + 1];

        // 인접 리스트 초기화
        for(int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 인접 리스트에 u,v 넣기
        for(int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int u = Integer.parseInt(data1[0]);
            int v = Integer.parseInt(data1[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;
        // 방문하지 않은 노드만 DFS 진행하기
        for (int i = 1; i < N + 1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);

    }

    static void DFS(int v) {
        visited[v] = true;
        for(int i : graph.get(v)) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}