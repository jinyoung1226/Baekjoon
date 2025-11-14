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

    static int N,D;
    static List<Node>[] graph;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        D = Integer.parseInt(data[1]);

        graph = new List[D+1];
        dist = new int[D+1];

        for (int i = 0; i <= D; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
            if (i != D) {
                graph[i].add(new Node(i+1, 1));
            }
        }

        for (int i = 0; i < N; i++) {
            String[] data1 = br.readLine().split(" ");
            int start = Integer.parseInt(data1[0]);
            int end = Integer.parseInt(data1[1]);
            int length = Integer.parseInt(data1[2]);

            if (end <= D) {
                graph[start].add(new Node(end, length));
            }
        }

        dijkstra(0);
        System.out.println(dist[D]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

}