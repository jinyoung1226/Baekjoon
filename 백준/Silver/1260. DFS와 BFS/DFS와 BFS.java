import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] DFS_visited;
    static boolean[] BFS_visited;
    static StringBuilder sb1;
    static StringBuilder sb2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        K = Integer.parseInt(data[2]);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        DFS_visited = new boolean[N + 1];
        BFS_visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int u = Integer.parseInt(data1[0]);
            int v = Integer.parseInt(data1[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(K);
        BFS(K);

        System.out.println(sb1);
        System.out.println(sb2);

    }

    static void DFS(int x) {
        DFS_visited[x] = true;
        sb1.append(x).append(" ");

        for (int i : graph.get(x)) {
            if (!DFS_visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        BFS_visited[x] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb2.append(poll).append(" ");

            for (int i : graph.get(poll)) {
                if (!BFS_visited[i]) {
                    BFS_visited[i] = true;
                    queue.add(i);
                }
            }

        }
    }

}