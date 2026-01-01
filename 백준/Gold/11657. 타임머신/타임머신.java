import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge (int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int N, M;
    static List<Edge> list;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        list = new ArrayList<>();
        dist = new long[N+1];

        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int start = Integer.parseInt(data1[0]);
            int end = Integer.parseInt(data1[1]);
            int cost = Integer.parseInt(data1[2]);

            list.add(new Edge(start, end, cost));
        }

        boolean checkMinusCycle = bellmanFord(1);
        if (checkMinusCycle) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static boolean bellmanFord(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i <= N; i++) {
            boolean changed = false;
            for (Edge edge : list) {
                if (dist[edge.start] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;
                    changed = true;

                    if (i == N) {
                        return true;
                    }
                }
            }


            if (!changed) {
                 break;
            }
        }

        return false;
    }
}