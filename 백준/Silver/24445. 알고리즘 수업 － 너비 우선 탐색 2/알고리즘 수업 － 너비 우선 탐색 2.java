import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int R = Integer.parseInt(data[2]);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int u = Integer.parseInt(data1[0]);
            int v = Integer.parseInt(data1[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        count = 1;
        BFS(R);

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int R) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        visited[R] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[poll] = count;
            count++;

            for (Integer i : graph.get(poll)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }


        }
    }
}