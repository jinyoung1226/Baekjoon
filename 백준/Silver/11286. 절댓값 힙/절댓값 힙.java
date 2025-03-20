import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs == secondAbs){
                return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수를 우선적으로 앞으로 정렬
            } else {
                return firstAbs - secondAbs;
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(pq.isEmpty()){
                    bw.write("0" + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(x);
            }
        }
        bw.flush();
    }
}