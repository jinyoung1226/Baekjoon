import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        long cost;

        public Node (int v, long cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int N,E;
    static long[] dist;
    static boolean[] visited;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        E = Integer.parseInt(data[1]);

        dist = new long[N+1];
        visited = new boolean[N+1];
        graph = new List[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] data1 = br.readLine().split(" ");
            int v1 = Integer.parseInt(data1[0]);
            int v2 = Integer.parseInt(data1[1]);
            int cost = Integer.parseInt(data1[2]);

            graph[v1].add(new Node(v2, cost));
            graph[v2].add(new Node(v1, cost));
        }

        String[] two_point = br.readLine().split(" ");
        int v1 = Integer.parseInt(two_point[0]);
        int v2 = Integer.parseInt(two_point[1]);

        // 1 -> v1 -> v2 -> N 으로 다익스트라를 3개로 잘라서 진행하는 경우
        long case1_first = dijkstra(1, v1);
        long case1_second = dijkstra(v1, v2);
        long case1_third = dijkstra(v2, N);
        long case1 = case1_first + case1_second + case1_third;

        // 1 -> v2 -> v1 -> N 으로 다익스트라를 3개로 잘라서 진행하는 경우
        long case2_first = dijkstra(1, v2);
        long case2_second = dijkstra(v2, v1);
        long case2_third = dijkstra(v1, N);
        long case2 = case2_first + case2_second + case2_third;

        if (case1_first == -1 || case1_second == -1 || case1_third == -1 || case2_first == -1 || case2_second == -1 || case2_third == -1) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(case1, case2));
        }

    }


    static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1.cost, o2.cost));
        for (int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
            visited[i] = false;
        }

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.v]) {
                continue;
            } else {
                visited[now.v] = true;
            }

            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        if (dist[end] == Long.MAX_VALUE) {
            return -1;
        } else {
            return dist[end];
        }
    }
}