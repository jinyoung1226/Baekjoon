import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int cost;
        List<Integer> route;

        public Node (int v, int cost, List<Integer> route) {
            this.v =v;
            this.cost = cost;
            this.route = route;
        }
    }

    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int N,M, start, destination;
    static int[] dist;
    static boolean[] visited;
    static List<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        dist = new int[N+1];
        arr = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);
            int cost = Integer.parseInt(data[2]);

            arr[start].add(new Node(end, cost, new ArrayList<>()));
        }

        String[] data = br.readLine().split(" ");
        start = Integer.parseInt(data[0]);
        destination = Integer.parseInt(data[1]);

        dijkstra(start, destination);

        int min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            if (key < min) {
                min = key;
            }
        }

        List<Integer> result = map.get(min);


        System.out.println(min);
        System.out.println(result.size()+1);
        System.out.print(start + " ");
        for (Integer i : result) {
            System.out.print(i + " ");
        }



    }

    public static void dijkstra(int start, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {return o1.cost - o2.cost;});
        pq.add(new Node(start, 0, new ArrayList<>()));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.v]) continue;
            else visited[now.v] = true;

            for (Node next : arr[now.v]) {
                if (dist[next.v] >= now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    List<Integer> newList = new ArrayList<>();
                    for (int i = 0; i < now.route.size(); i++) {
                        newList.add(now.route.get(i));
                    }

                    newList.add(next.v);

                    pq.add(new Node (next.v, dist[next.v], newList));

                    if (next.v == destination) {
                        map.put(dist[destination], newList);
                    }
                }
            }
        }

    }
}