import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int T;
    static int A;
    static int B;
    static List<Integer> A_arr;
    static List<Integer> B_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            A_arr = new ArrayList<>();
            B_arr = new ArrayList<>();

            String[] data = br.readLine().split(" ");
            A = Integer.parseInt(data[0]);
            B = Integer.parseInt(data[1]);

            String[] A_data = br.readLine().split(" ");
            for (String str : A_data) {
                A_arr.add(Integer.parseInt(str));
            }

            String[] B_data = br.readLine().split(" ");
            for (String str : B_data) {
                B_arr.add(Integer.parseInt(str));
            }
            Collections.sort(B_arr);

            int start = 0;
            int end = B_arr.size() - 1;

            int result = 0;
            for (int j = 0; j < A_arr.size(); j++) {
                Integer A_number = A_arr.get(j);
                int result1 = BinarySearch(start, end, A_number);
                result += result1;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static int BinarySearch(int start, int end, int A_number) {
        int count = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            if (A_number <= B_arr.get(mid)) {
                end = mid - 1;
            } else {
                count = mid + 1;
                start = mid + 1;
            }
        }

        return count;
    }
}