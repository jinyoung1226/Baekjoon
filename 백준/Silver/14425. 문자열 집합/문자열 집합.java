import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        int result = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(set.contains(s)) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}