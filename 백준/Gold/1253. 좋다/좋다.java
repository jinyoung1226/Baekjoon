import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 수 입력
        String[] data = br.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(data[i]);
        }

        // 입력받은 배열 오름차순으로 정렬
        Arrays.sort(array);

        // 좋은 수 몇 번 나왔는지 count 하는 변수
        int count = 0;

        for (int i = 0; i < N; i++) {
            long K = array[i];
            int start = 0;
            int end = N - 1;

            while(start < end) {
                if(array[start] + array[end] == K) {
                    if(start != i && end != i) {
                        count ++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (array[start] + array[end] > K) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}