import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        String[] data1 = br.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data1[i]);
        }

        Arrays.sort(arr);

        backTracking(0);


    }

    static void backTracking(int depth) {
        if (depth == M) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
                list.remove((Integer) arr[i]);
            }
        }
    }
}
