import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int cost;

        public Node (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int N, M, X;
    static List<Node>[] graph;
    static int[] go_arr;
    static int[] back_arr;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        X = Integer.parseInt(data[2]);

        go_arr = new int[N+1];
        back_arr = new int[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int start = Integer.parseInt(data1[0]);
            int end = Integer.parseInt(data1[1]);
            int cost = Integer.parseInt(data1[2]);

            graph[start].add(new Node(end, cost));
        }

        // 모든 지점에서 X번으로 갈떄의 최소 거리 구한 후 -> go_arr에 각 노드에 가는 최단 거리 저장하기
        for (int i = 1; i <= N; i++) {
            go_arr[i] = dijkstra(i, X);
        }

        // X지점에서 모든 지점으로 가는 최소 거리 구한 후 -> back_arr에 각 노드에 가는 최단 거리 저장하기
        for (int i = 1; i <= N; i++) {
            back_arr[i] = dijkstra(X, i);
        }

        int[] result = new int[N+1];

        for (int i = 0; i < result.length; i++) {
            result[i] += (go_arr[i] + back_arr[i]);
        }

        Arrays.sort(result);
        System.out.println(result[result.length - 1]);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.v]) {
                visited[now.v] = true;
            } else {
                continue;
            }

            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }
}