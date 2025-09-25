import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int V = Integer.parseInt(data[0]);
        int E = Integer.parseInt(data[1]);
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int start_vertex) {
        dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start_vertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start_vertex, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int current_vertex = node.vertex;
            int current_cost = node.cost;

            if (dist[current_vertex] < current_cost) {
                continue;
            }

            for (Node neighbor: graph.get(current_vertex)) {
                int newCost = dist[current_vertex] + neighbor.cost;

                if (dist[neighbor.vertex] > newCost) {
                    dist[neighbor.vertex] = newCost;
                    pq.add(new Node(neighbor.vertex, newCost));
                }
            }
        }

    }

}