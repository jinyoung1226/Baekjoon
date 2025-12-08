import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] arr;
    static int[] parents;
    static int[] depth;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        depth = new int[N+1];
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);

            arr[a].add(b);
            arr[b].add(a);
        }

        // parent 배열 세팅
        DFS(1, 1, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int first = Integer.parseInt(data[0]);
            int second = Integer.parseInt(data[1]);

            System.out.println(LCA(first, second));
        }
    }

    static void DFS(int current, int height, int parent) {
        depth[current] = height;
        parents[current] = parent;

        for (Integer child : arr[current]) {
                if (child != parent) {
                    DFS(child, height+1, current);
            }
        }
    }

    static int LCA(int first, int second) {
        int first_depth = depth[first];
        int second_depth = depth[second];

        while (first_depth < second_depth) {
            second = parents[second];
            second_depth--;
        }

        while (first_depth > second_depth) {
            first = parents[first];
            first_depth--;
        }

        while (first != second) {
            first = parents[first];
            second = parents[second];
        }

        return first;


    }

}