import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int second;

        public Node (int x, int second) {
            this.x = x;
            this.second = second;
        }
    }

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        bfs(N);

    }

    public static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        parent[start] = -1;
        q.add(new Node(start, 0));
        visited[start] = true;

        int second = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == K) {
                second = now.second;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nextX;
                if (i == 0) {
                    nextX = now.x + 1;
                } else if (i == 1) {
                    nextX = now.x - 1;
                } else {
                    nextX = now.x * 2;
                }

                if (nextX >= 0 && nextX <= 100000) {
                    if (!visited[nextX]) {
                        visited[nextX] = true;
                        parent[nextX] = now.x;
                        q.add(new Node(nextX, now.second + 1));
                    }
                }
            }
        }
        System.out.println(second);

        List<Integer> path = new ArrayList<>();
        path.add(K);
        int v = K;
        while (true) {
            int vertex = parent[v];
            if (vertex != -1) {
                path.add(vertex);
            } else {
                break;
            }
            v = vertex;
        }

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(path.size() - i -1) + " ");
        }

    }
}