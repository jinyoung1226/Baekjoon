import java.io.*;
import java.util.*;

public class Main {

    static int T,N;
    static String[] sort_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            sort_arr = new String[N];

            // 정렬 배열 세팅
            for (int j = 0; j < N; j++) {
                String call_number = br.readLine();
                sort_arr[j] = call_number;
            }

            Arrays.sort(sort_arr);

            System.out.println(consistency_check());

        }
    }

    static String consistency_check() {
        for (int i = 0; i < N-1; i++) {
            if (sort_arr[i+1].startsWith(sort_arr[i])) {
                return "NO";
            }
        }

        return "YES";
    }
}
