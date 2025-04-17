import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            if(data.equals("ENTER")) {
                set.clear();
            } else {
                if(set.contains(data)) {
                    continue;
                } else {
                    result++;
                    set.add(data);
                }
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}