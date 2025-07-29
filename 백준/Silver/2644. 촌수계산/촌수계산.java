import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n;
    static int u;
    static int v;
    static int m;
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    static int check = -1 ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        u = Integer.parseInt(data[0]);
        v = Integer.parseInt(data[1]);
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] data1 = br.readLine().split(" ");
            int u = Integer.parseInt(data1[0]);
            int v = Integer.parseInt(data1[1]);
            map.get(u).add(v);
            map.get(v).add(u);
        }
        bfs(u, v);
        System.out.println(check);
    }

    static void bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int depth = poll[1];

            if (node == end) {
                check = depth;
                break;
            }

            for (int i : map.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(new int[]{i, depth + 1});
                }
            }
        }
    }
}