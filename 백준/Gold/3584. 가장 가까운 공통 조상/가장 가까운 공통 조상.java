import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            visited = new boolean[N+1];
            arr = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = new ArrayList<>();
            }

            for (int j = 0; j < N - 1; j++) {
                String[] data = br.readLine().split(" ");
                int parent = Integer.parseInt(data[0]);
                int child = Integer.parseInt(data[1]);

                arr[child].add(parent);
            }

            String[] data = br.readLine().split(" ");
            int first = Integer.parseInt(data[0]);
            int second = Integer.parseInt(data[1]);
            System.out.println(BFS(first, second));
        }
    }

    static int BFS(int first, int second) {
        Queue<Integer> q = new LinkedList<>();
        q.add(first);
        q.add(second);

        int result = 0;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            if (visited[now]) {
                result = now;
                break;
            }

            visited[now] =true;

            if (arr[now].isEmpty()) {
                continue;
            }

            q.add(arr[now].get(0));

        }

        return result;

    }
}