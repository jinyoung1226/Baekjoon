import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        HashMap<String, Boolean> map = new HashMap<>();
        String[] bodo_arr = new String[M];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, true);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                result.add(str);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
