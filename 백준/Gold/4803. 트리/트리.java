import java.io.*;
import java.util.*;

public class Main {

    static int case_num = 1;
    static List<Integer>[] arr;
    static boolean[] visited;
    static boolean hasCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = br.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);

            // 탈출 조건
            if (n == 0 && m == 0) {
                break;
            }

            // 배열 세팅
            arr = new ArrayList[n+1];
            visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            // 트리 세팅
            for (int i = 0; i < m; i++) {
                String[] data1 = br.readLine().split(" ");
                int a = Integer.parseInt(data1[0]);
                int b = Integer.parseInt(data1[1]);

                arr[a].add(b);
                arr[b].add(a);
            }


            int sub_tree_count = 0;
            for (int i = 1; i <= n; i++) {
                hasCycle = false;
                if (!visited[i]) {
                    DFS(i, -1);

                    if (!hasCycle) {
                        sub_tree_count++;
                    }
                }
            }

            if (sub_tree_count > 1) {
                System.out.println("Case " + case_num + ": A forest of " + sub_tree_count + " trees.");
            } else if (sub_tree_count == 1) {
                System.out.println("Case " + case_num + ": There is one tree.");
            } else {
                System.out.println("Case " + case_num + ": No trees.");
            }

            case_num++;
        }
    }

    static void DFS(int v, int parent) {
        visited[v] = true;

        for (Integer next : arr[v]) {
            if (next == parent) { // 다음 노드가 직전의 부모를 만나는 건 괜찮다.
                continue;
            }
            if (visited[next]) { // 직전의 부모가 아닌 다른 노드 중에 방문한 것이 있다? 그럼 사이클
                hasCycle = true;
                return;
            }

            DFS(next, v);
        }
    }
}