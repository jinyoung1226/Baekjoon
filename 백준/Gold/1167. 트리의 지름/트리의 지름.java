import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static int result = 0;
    static int savePoint = 0;
    static List<List<int []>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            String[] data = br.readLine().split(" ");
            int p = Integer.parseInt(data[0]);

            int j = 1;
            while (!data[j].equals("-1")) {
                int n = Integer.parseInt(data[j]);
                int m = Integer.parseInt(data[j + 1]);

                graph.get(p).add(new int[]{n, m});
                j += 2;
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(savePoint, 0);

        System.out.println(result);

    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if(distance > result) {
            result = distance;
            savePoint = node;
        }

        for (int[] h : graph.get(node)) {
            if (!visited[h[0]]) {
                dfs(h[0], distance + h[1]);
            }
        }
    }
}