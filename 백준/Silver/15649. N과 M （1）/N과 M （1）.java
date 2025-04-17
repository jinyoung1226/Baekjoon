import java.io.*;

public class Main {

    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        visit =  new boolean[N];
        arr = new int[M];
        backTracking(0);
        bw.flush();

    }

    private static void backTracking(int depth) throws IOException {
        if(depth == M) {
            for (int number : arr) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                backTracking(depth + 1);
                visit[i] = false;
            }
        }
    }
}