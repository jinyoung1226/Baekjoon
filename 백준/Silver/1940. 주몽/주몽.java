import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 개수 입력 받은 후, 배열을 오름차순으로 정렬
        String[] data = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }
        Arrays.sort(arr);


        //  시작 포인트와 엔드 포인트 지정 후, 가운데에서 만날 때까지 계산
        int i = 0; // 시작 포인트
        int j = N - 1; // 엔드 포인트
        int count = 0; // 횟수 카운트

        while (i < j) {
            if(arr[i] + arr[j] < M) {
                i++;
            } else if(arr[i] + arr[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}