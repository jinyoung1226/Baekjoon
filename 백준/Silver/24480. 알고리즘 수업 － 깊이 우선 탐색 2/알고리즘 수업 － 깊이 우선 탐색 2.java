import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] visited;
    static int visitedCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input_data = br.readLine().split(" ");
        N = Integer.parseInt(input_data[0]);
        M = Integer.parseInt(input_data[1]);
        R = Integer.parseInt(input_data[2]);

        visited = new int[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int u = Integer.parseInt(data[0]);
            int v = Integer.parseInt(data[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i < N+1; i++) {
            sb.append(visited[i] + "\n");
        }

        System.out.println(sb);

    }


    static void dfs(int v) {
        visitedCount++;
        visited[v] = visitedCount;

        for (Integer i : graph.get(v)) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
    }
}