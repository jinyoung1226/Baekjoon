import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> queue = new ArrayDeque<>();

        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < N; i++) {
            int idx = i + 1;
            Balloon insertBalloon = new Balloon(idx, arr[i]);
            queue.addLast(insertBalloon);
        }

        int[] result = new int[N];
        int insertIndex = 0;

        while(!queue.isEmpty()) {
            int value = queue.getFirst().value;
            int idx = queue.getFirst().index;
            result[insertIndex] = idx;

            if (queue.size() == 1) break;

            // 양수일 경우
            if(value > 0) {
                for(int i = 0; i < value; i++) {
                    if(i == 0) {
                        queue.pollFirst();
                    } else {
                        Balloon balloon = queue.pollFirst();
                        queue.addLast(balloon);
                    }
                }
            } else {
                for(int i = 0; i <= Math.abs(value); i++) {
                    if(i == 0) {
                        queue.pollFirst();
                    } else {
                        Balloon balloon = queue.pollLast();
                        queue.addFirst(balloon);
                    }
                }
            }
            insertIndex++;
        }

        for(int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
    }

    static class Balloon {
        int index;
        int value;

        public Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}