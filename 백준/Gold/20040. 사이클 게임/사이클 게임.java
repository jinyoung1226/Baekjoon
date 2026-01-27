import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 점의 집합을 나타내는 배열 초기화
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        // M번 반복하면서 find == find 시 부모가 같으면 사이클이 발생
        // 발생 하면 break 후 i 값에 순서로 result 대입
        // 발생 안 하면 union 후 다음 반복 시작
        for (int i = 1; i <= M; i++) {
            String[] selectedTwoPoint = br.readLine().split(" ");
            int firstPoint = Integer.parseInt(selectedTwoPoint[0]);
            int twoPoint = Integer.parseInt(selectedTwoPoint[1]);

            if (find(firstPoint) == find(twoPoint)) {
                result = i;
                break;
            } else union(firstPoint, twoPoint);
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx < ny) parent[ny] = nx;
        else parent[nx] = ny;
    }
}