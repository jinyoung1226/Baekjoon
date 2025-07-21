import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int flag = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int u = Integer.parseInt(data1[0]);
            int v = Integer.parseInt(data1[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < N; i++) {
            if(flag == 0) {
                DFS(i, 1);
            }
        }

        System.out.println(flag);


    }

    static void DFS(int x, int depth) {
        if(depth == 5) {
            flag = 1;
            return;
        }

        visited[x] = true;

        for (int i : graph.get(x)) {
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
         }

        visited[x] = false;
     }

}