import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int cal = Integer.parseInt(data1[0]);
            int a = Integer.parseInt(data1[1]);
            int b = Integer.parseInt(data1[2]);

            if (cal == 0) {
                union(a,b);
            } else {
                boolean check = check(a,b);
                if (check) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }


    }

    static void union(int a, int b) {
        int a1 = find(a);
        int b1 = find(b);

        if (a1 < b1) {
            arr[b1] = a1;
        } else {
            arr[a1] = b1;
        }
    }

    static int find(int x) {
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    static boolean check(int a, int b) {
        return find(a) == find(b);
    }
}