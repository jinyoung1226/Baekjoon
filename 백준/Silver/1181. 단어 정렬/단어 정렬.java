import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for ( int i = 0; i < N; i++) {
            String data = br.readLine();
            set.add(data);
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (a , b) -> {
            if(a.length() < b.length()) {
                return -1;
            } else if(a.length() > b.length()) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });


        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
    }
}