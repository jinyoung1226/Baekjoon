import java.io.*;

public class Main {

    static int N, M;
    static int start, end;
    static int[] lesson;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        lesson = new int[N];
        String[] data1 = br.readLine().split(" ");

        int sum = 0;
        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(data1[i]);
            sum += lesson[i];
            start = Math.max(start, lesson[i]);
        }

        end = sum;
        System.out.println(BiSearch(start, end));
    }


    static int BiSearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += lesson[i];
                if (sum > mid) {
                    count++;
                    sum = lesson[i];
                }
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}