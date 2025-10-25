import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];

        for (int i = 1; i <= arr.length-1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        sb.append(list.size() + "\n");
        Collections.sort(list);
        for (Integer i : list) {
            sb.append(i + "\n");
        }

        System.out.println(sb);

    }

    public static void dfs(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }

        if (arr[start] == target) {
            list.add(target);
        }
    }
}
