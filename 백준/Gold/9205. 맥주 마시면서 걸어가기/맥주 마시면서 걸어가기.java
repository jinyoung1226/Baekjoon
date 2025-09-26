import java.io.*;
import java.util.*;


public class Main {

    static int t, n;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i ++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n+2];

            for (int j = 0; j < n+2; j++) {
                list.add(new int[2]);
            }

            for (int z = 0; z < n+2; z++) {
                String[] data = br.readLine().split(" ");
                list.get(z)[0] = Integer.parseInt(data[0]);
                list.get(z)[1] = Integer.parseInt(data[1]);
            }
            bfs(list.get(0)[0],list.get(0)[1]);

            list = new ArrayList<>();
            Arrays.fill(visited, false);
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visited[0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int dx = poll[0];
            int dy = poll[1];

            // 여기서 페스티벌인지 체크하고 있으면 break;
            if (dx == list.get(list.size()-1)[0] && dy == list.get(list.size()-1)[1]) {
                sb.append("happy").append("\n");
                return;
            }

            for (int i = 0; i < list.size(); i ++) {
                if (!visited[i]) {
                    if (Math.abs(list.get(i)[0] - dx) + Math.abs(list.get(i)[1] - dy) <= 1000) {
                        queue.add(new int[]{list.get(i)[0], list.get(i)[1]});
                        visited[i] = true;
                    }
                }
            }
        }
        sb.append("sad").append("\n");
    }
}