import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int[] arr;
    static List<Integer>[] depth_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        arr = new int[(int)Math.pow(2, K) - 1];
        depth_arr = new ArrayList[K];

        for (int i = 0 ; i < depth_arr.length; i++) {
            depth_arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        int start = 0;
        int end = arr.length - 1;
        Search(start, end, 0);

        for (int i = 0; i < depth_arr.length; i++) {
            for (int j = 0; j < depth_arr[i].size(); j++) {
                sb.append(depth_arr[i].get(j) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void Search(int start, int end, int depth) {
        if (depth == K) {
            return;
        }
        int mid = (start + end) / 2;
        depth_arr[depth].add(arr[mid]);

        Search(start, mid-1, depth + 1);
        Search(mid+1, end, depth + 1);
    }
}