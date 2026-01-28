import java.io.*;
import java.util.*;

public class Main {

    static int N,M,K;
    static int[] parent;
    static int[] friendPay;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        parent = new int[N+1];
        friendPay = new int[N+1];

        String[] pay = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            friendPay[i] = Integer.parseInt(pay[i-1]);
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] relation = br.readLine().split(" ");
            int v = Integer.parseInt(relation[0]);
            int w = Integer.parseInt(relation[1]);

            union(v,w);
        }
        
        for (int i = 1; i <= N; i++) {
            int root = find(i);

            if (!map.containsKey(root)) map.put(root, new ArrayList<>());
            map.get(root).add(i);
        }

        int result = 0;

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            int min = Integer.MAX_VALUE;
            for (Integer value : list) {
                if (friendPay[value] < min) min = friendPay[value];
            }

            if (K >= min) {
                result += min;
                K -= min;
            } else {
                System.out.println("Oh no");
                return;
            }
        }

        System.out.println(result);

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