import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int N,M;
    static List<Node>[] graph;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            String[] data1 = br.readLine().split(" ");
            int a = Integer.parseInt(data1[0]);
            int b = Integer.parseInt(data1[1]);
            int cost = Integer.parseInt(data1[2]);

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            int answer = BFS(start, end);
            System.out.println(answer);
            visited = new boolean[N+1];
            result = new int[N+1];
        }
    }

    static int BFS(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        result[start] = 0;
        visited[start] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node next : graph[now.v]) {
                if (!visited[next.v]) {
                    q.add(new Node(next.v, now.cost + next.cost));
                    visited[next.v] = true;
                    result[next.v] = now.cost + next.cost;
                }
            }
        }

        return result[end];
    }
}