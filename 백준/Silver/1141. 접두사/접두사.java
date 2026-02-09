import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<String> list = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                continue;
            } else {
                set.add(input);
                list.add(input);
            }
        }
        
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                if (list.get(j).startsWith(list.get(i))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}