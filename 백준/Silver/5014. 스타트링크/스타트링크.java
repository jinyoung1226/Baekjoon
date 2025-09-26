import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static class Point {
        int x;
        int click;

        public Point(int x, int click) {
            this.x = x;
            this.click = click;
        }
    }

    static int F, S, G, U, D;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        F = Integer.parseInt(data[0]);
        S = Integer.parseInt(data[1]);
        G = Integer.parseInt(data[2]);
        U = Integer.parseInt(data[3]);
        D = Integer.parseInt(data[4]);

        arr = new int[F+1];
        visited = new boolean[F+1];

        bfs();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(S, 0));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int click = point.click;

            if (x == G) {
                System.out.println(click);
                return;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    if (x+U <= F && !visited[x+U]) {
                        queue.add(new Point(x+U, click+1));
                        visited[x+U] = true;
                    }

                    if (x-D > 0 && !visited[x-D]) {
                        queue.add(new Point(x-D, click+1));
                        visited[x-D] = true;
                    }
                }
            }
        }
        System.out.println("use the stairs");
    }
}