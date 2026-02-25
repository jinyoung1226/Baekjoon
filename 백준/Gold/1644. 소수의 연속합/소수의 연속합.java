import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (true) {

            if (sum >= N) {
                sum -= primes.get(left++);
            } else if (right == primes.size()) {
                break;
            } else {
                sum += primes.get(right++);
            }

            if (sum == N) count++;
        }

        System.out.println(count);


    }
}