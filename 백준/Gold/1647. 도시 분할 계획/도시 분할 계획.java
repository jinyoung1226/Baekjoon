import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge (int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static int N, M;
    static List<Edge> list = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 0; i < M; i++) {
            String[] edgeInput = br.readLine().split(" ");
            int start = Integer.parseInt(edgeInput[0]);
            int end = Integer.parseInt(edgeInput[1]);
            int cost = Integer.parseInt(edgeInput[2]);

            list.add(new Edge(start, end, cost));
        }

        // parent 배열 초기화
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 간선 비용 오름차순으로 정렬 (가장 중요) -> 간선이 가장 작은 것부터 사이클이 생기는지 안 생기는지 탐색해서 MST를 구축하기 떄문
        Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);

        int count = 0;
        int mstWeight = 0;
        int max = Integer.MIN_VALUE;
        for (Edge edge : list) {
            if (find(edge.v1) != find(edge.v2)){
                union(edge.v1, edge.v2);
                count++;
                mstWeight += edge.cost;
                max = Math.max(max, edge.cost);
                if (count == N-1) break;
            }
        }

        System.out.println(mstWeight-max);



    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx > ny) parent[nx] = ny;
        else parent[ny] = nx;
    }
}
