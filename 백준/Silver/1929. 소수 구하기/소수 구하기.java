import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        for (int i = M; i < N+1; i++) {
            isPrime(i);
        }

        for (Integer a : list) {
            System.out.println(a);
        }

    }

    static void isPrime(int v) {
        if (v == 1) return;
        for (int i = 2; i*i <= v; i++) {
            if (v % i == 0) {
                return;
            }
        }

        list.add(v);
    }
}