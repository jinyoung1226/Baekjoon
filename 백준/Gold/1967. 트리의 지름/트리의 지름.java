import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static int result = 0;
    static List<List<int []>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < V; i++) {
            String[] data = br.readLine().split(" ");
            int p = Integer.parseInt(data[0]);
            int c = Integer.parseInt(data[1]);
            int d = Integer.parseInt(data[2]);

            graph.get(p).add(new int[]{c, d});
            graph.get(c).add(new int[]{p, d});
        }

        for (int i = 1; i <= V; i++) {
            visited = new boolean[V + 1];
            dfs(i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;
        result = Math.max(distance, result);

        for (int[] arr: graph.get(node)) {
            if(!visited[arr[0]]) {
                dfs(arr[0], distance + arr[1]);
            }
        }
    }
}