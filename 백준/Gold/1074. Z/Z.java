import java.io.*;
import java.util.*;

public class Main {

    static int N,r,c ;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        r = Integer.parseInt(data[1]);
        c = Integer.parseInt(data[2]);

        int size = (int)Math.pow(2, N);
        divide(size, 0, 0);
        System.out.println(count);


    }

    static void divide(int size, int x, int y) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        // 1사분면 탐색
        if (r < x + half && c < y + half) {
            divide(half, x, y);
        }

        // 2사분면 탐색
        else if (r < x + half && c >= y + half) {
            count += half * half;
            divide(half, x, y + half);
        }

        // 3사분면 탐색
        else if (r >= x + half && c < y + half) {
            count += half*half*2;
            divide(half, x+half, y);
        }

        // 4사분면 탐색
        else {
            count += half*half*3;
            divide(half, x+half, y+half);
        }
    }
}
