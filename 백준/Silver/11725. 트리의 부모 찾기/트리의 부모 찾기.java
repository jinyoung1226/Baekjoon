import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        result = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i =  2; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int parent) {
        visited[parent] = true;

        for (Integer child : graph[parent]) {
            if (!visited[child]) {
                result[child] = parent;
                DFS(child);
            }
        }
    }
}