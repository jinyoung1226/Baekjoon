import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] arr;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] data = br.readLine().split(" ");
            arr[Integer.parseInt(data[0])].add(Integer.parseInt(data[1]));
            arr[Integer.parseInt(data[1])].add(Integer.parseInt(data[0]));
        }

        count = 0;
        bfs(1, 0);
        System.out.println(count);
    }

    public static void bfs(int start, int depth) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int nowDepth = now[1];

            if (nowDepth >= 2) continue;

            for (Integer next : arr[node]) {
                if (!visited[next]) {
                    visited[next]= true;
                    count++;
                    q.add(new int[]{next, nowDepth+1});
                }
            }


        }
    }
}