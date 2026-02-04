import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr= new char[N];
        String bench = br.readLine();
        for (int i = 0; i < bench.length(); i++) {
            arr[i] = bench.charAt(i);
        }

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            // 'P' 사람인 경우에만 체크
            if (arr[i] == 'P') {
                for (int j = i-M; j <= i+M; j++) {
                    // j가 음수이면 배열 초과이므로 체크 필요 없음
                    if (j < 0 || j == i || j > arr.length-1) continue;
                    //자기 자신이어도 체크 필요 없음
                    if (j == i) continue;

                    if (arr[j] == 'H') {
                        arr[j] = 'X';
                        total += 1;
                        break;
                    }
                }
            }
        }

        System.out.println(total);
    }
}