import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int minPack = Integer.MAX_VALUE;
        int minUnit = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int unit = Integer.parseInt(st.nextToken());

            minPack = Math.min(minPack, pack);
            minUnit = Math.min(minUnit, unit);
        }

        int result = Math.min(((N / 6) + 1) * minPack, N * minUnit); 
        result = Math.min(result, (N / 6) * minPack + (N % 6) * minUnit); 
        System.out.println(result);
    }
}