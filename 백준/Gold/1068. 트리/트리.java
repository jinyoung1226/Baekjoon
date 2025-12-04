import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int delete_node;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        String[] data = br.readLine().split(" ");
        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(data[i]);

            if (parent == -1) {
                root = i;              // 루트 결정
            } else {
                graph[i].add(parent);
                graph[parent].add(i);  // 양방향
            }
        }

        delete_node = Integer.parseInt(br.readLine());

        if (delete_node == root) {
            System.out.println(0);
        } else {
            BFS(root);
            System.out.println(result);
        }
    }

    static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;

        while(!q.isEmpty()) {
            Integer now = q.poll();
            int child_count = 0;

            for (Integer next : graph[now]) {
                if (!visited[next] && next != delete_node) {
                    q.add(next);
                    visited[next] = true;
                    child_count++;
                }
            }

            if (child_count == 0) {
                result++;
            }
        }
    }
}