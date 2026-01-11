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

    static int N, M, R;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    static int[] items;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        R = Integer.parseInt(data[2]);

        list = new List[N+1];
        items = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        String[] data1 = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(data1[i-1]);
        }

        for (int i = 0; i < R; i++) {
            String[] data2 = br.readLine().split(" ");
            int a = Integer.parseInt(data2[0]);
            int b = Integer.parseInt(data2[1]);
            int l = Integer.parseInt(data2[2]);

            list[a].add(new Node(b, l));
            list[b].add(new Node(a, l));
        }

        int max = 0;
        // 데이크스트라 실행
        for (int i = 1; i <= N; i++) {
            int result = dijkstra(i);
            if (result > max) {
                max = result;
            }
        }

        System.out.println(max);
    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.v]) {
                continue;
            }

            visited[now.v] = true;

            for (Node next : list[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    if (now.cost + next.cost <= M) {
                        dist[next.v] = now.cost + next.cost;
                        pq.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                sum += items[i];
            }
        }

        return sum;
    }
}