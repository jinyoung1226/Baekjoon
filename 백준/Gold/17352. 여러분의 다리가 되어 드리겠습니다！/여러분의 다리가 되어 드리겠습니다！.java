import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N-2; i++) {
            String[] bridge = br.readLine().split(" ");
            int firstIsland = Integer.parseInt(bridge[0]);
            int secondIsland = Integer.parseInt(bridge[1]);

            union(firstIsland, secondIsland);
        }

        int firstResult = parent[1];
        int secondResult = 0;
        for (int i = 2; i < parent.length; i++) {
            if (find(i) != firstResult) {
                secondResult = i;
                break;
            }
        }

        System.out.println(firstResult + " " + secondResult);

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx < ny) parent[ny] = nx;
        else parent[nx] = ny;
    }
}
