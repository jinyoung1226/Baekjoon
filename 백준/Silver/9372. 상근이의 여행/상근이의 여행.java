import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M;
    static List<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            M = Integer.parseInt(data[1]);

            arr = new ArrayList[N+1];
            visited = new boolean[N+1];
            for (int j = 1; j < arr.length; j++) {
                arr[j] = new ArrayList<>();
            }

            for (int j = 0; j < M; j++) {
                String[] data1 = br.readLine().split(" ");
                int a = Integer.parseInt(data1[0]);
                int b = Integer.parseInt(data1[1]);

                arr[a].add(b);
                arr[b].add(a);
            }

            int result = bfs();
            visited = new boolean[N+1];
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int result = 0;

        while(!q.isEmpty()) {
            Integer now = q.poll();
            for (Integer next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    result++;
                }
            }
        }

        return result;
    }
}
