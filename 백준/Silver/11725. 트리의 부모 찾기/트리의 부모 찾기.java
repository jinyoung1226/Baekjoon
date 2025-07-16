import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        results = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] data = br.readLine().split(" ");
            int u = Integer.parseInt(data[0]);
            int v = Integer.parseInt(data[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        DFS(1);

        for (int i = 2; i < N + 1; i++) {
            sb.append(results[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void DFS(int parent) {
        visited[parent] = true;

        for (int child : graph.get(parent)) {
            if(!visited[child]) {
                results[child] = parent;
                DFS(child);
            }
        }
    }
}