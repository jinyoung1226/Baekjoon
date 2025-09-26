import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N, K;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        K = Integer.parseInt(data[1]);


        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int shortTime = Integer.MAX_VALUE;
        int count = 0;

        Arrays.fill(time, -1);
        time[N] = 0;

        while(!queue.isEmpty()) {
            Integer currentX = queue.poll();

            if (shortTime < time[currentX]) {
                break;
            }

            if (currentX == K) {
                // 첫 발견일 경우
                if (shortTime == Integer.MAX_VALUE) {
                    shortTime = time[currentX];
                }

                if (shortTime == time[currentX]) {
                    count++;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int nextX = currentX - 1;
                    if (nextX >= 0 && nextX <= 100000) {
                        if (time[nextX] == -1 || time[nextX] == time[currentX] + 1) {
                            time[nextX] = time[currentX] + 1;
                            queue.add(nextX);
                        }
                    }
                }

                if (i == 1) {
                    int nextX = currentX + 1;
                    if (nextX >= 0 && nextX <= 100000) {
                        if (time[nextX] == -1 || time[nextX] == time[currentX] + 1) {
                            time[nextX] = time[currentX] + 1;
                            queue.add(nextX);
                        }
                    }
                }

                if (i == 2) {
                    int nextX = currentX * 2;
                    if (nextX >= 0 && nextX <= 100000) {
                        if (time[nextX] == -1 || time[nextX] == time[currentX] + 1) {
                            time[nextX] = time[currentX] + 1;
                            queue.add(nextX);
                        }
                    }
                }
            }
        }
        System.out.println(shortTime);
        System.out.println(count);
    }
}