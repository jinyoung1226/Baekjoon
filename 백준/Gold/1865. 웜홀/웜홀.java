import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int cost;

        public Node ( int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int N, M, W;
    static List<Node>[] arr;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            // N, M, W 입력 받기
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            M = Integer.parseInt(data[1]);
            W = Integer.parseInt(data[2]);

            // 배열 초기화
            arr = new ArrayList[N+1];
            dist = new long[N+1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }

            // 도로 간선 정보 입력받기
            for (int i = 0; i < M; i++) {
                String[] data1 = br.readLine().split(" ");
                int S = Integer.parseInt(data1[0]);
                int E = Integer.parseInt(data1[1]);
                int T = Integer.parseInt(data1[2]);

                arr[S].add(new Node(E,T));
                arr[E].add(new Node(S,T));
            }

            // 웜홀 간선 정보 입력받기 (웜홀은 -로 넣어줘야 하며, 방향이 존재함)
            for (int i = 0; i < W; i++) {
                String[] data1 = br.readLine().split(" ");
                int S = Integer.parseInt(data1[0]);
                int E = Integer.parseInt(data1[1]);
                int T = Integer.parseInt(data1[2]);

                arr[S].add(new Node(E,-T));
            }

            boolean hasMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    hasMinusCycle = true;
                    break;
                }
            }

            if (hasMinusCycle) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean bellmanFord(int start) {
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        // n-1번 순회에 더해 마지막 음수 사이클 체크를 위해 +1로 N번 순휘
        for (int i = 1; i <= N; i++) {
            boolean changed = false;
            for (int j = 1; j <= N; j++) {
                for (Node node : arr[j]) {
                    if (dist[j] == Long.MAX_VALUE) continue;

                    if (dist[node.v] > dist[j] + node.cost) {
                        dist[node.v] = dist[j] + node.cost;
                        changed = true;

                        if (i == N) {
                            return true;
                        }
                    }
                }
            }
            if (!changed) break;
        }
        return false;
    }
}