import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();

        String input = br.readLine();

        int plus = 1;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                set.add(input.substring(j, plus + j));
            }
            plus++;
        }

        System.out.println(set.size());
    }
}