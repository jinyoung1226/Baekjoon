import java.io.*;
import java.util.*;

public class Main {
    static int[] A_arr;
    static int[] B_arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        A_arr = new int[N];
        B_arr = new int[M];
        list = new ArrayList<>();

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A_arr[i] = Integer.parseInt(data1[i]);
        }

        String[] data2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B_arr[i] = Integer.parseInt(data2[i]);
        }

        for (int i = 0; i < N; i++) {
             list.add(A_arr[i]);
        }

        for (int i = 0; i < M; i++) {
            list.add(B_arr[i]);
        }
        Collections.sort(list);


        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }


        System.out.println(sb);
    }
}