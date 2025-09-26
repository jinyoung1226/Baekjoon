import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static class Point {
        int x;
        int time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int N, K;
    static int[] arr = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        K = Integer.parseInt(data[1]);


        bfs(N);
    }

    static void bfs(int N) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int time = point.time;

            visited[x] = true;

            if (point.x == K) {
                System.out.println(point.time);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    if (x+1 <= 100000 && !visited[x+1]) {
                        queue.add(new Point(x+1, time+1));
                    }
                }

                if (i == 1) {
                    if (x-1 >= 0 && !visited[x-1]) {
                        queue.add(new Point(x-1, time+1));
                    }
                }

                if (i == 2) {
                    if (2*x <= 100000 && !visited[2*x]) {
                        queue.add(new Point(2*x, time+1));
                    }
                }
            }
        }
    }
}