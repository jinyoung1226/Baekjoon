import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];

        zoac(0, str.length() - 1);
        System.out.println(sb);

    }

    static void zoac(int left, int right) {
        if (left > right) {
            return;
        }


        // 1. 우선 Left ~ right 사이에서 사전순으로 가장 앞인 index 찾기
        int idx = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }

        // 2. 가장 사전 순으로 앞인 index의 방문 배열에 True 체크
        visited[idx] = true;

        // 3. 방문 배열 순회 한 번 해서 사전순 문자 출력해주기
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }

        sb.append("\n");

        // 4. idx를 기준으로 왼쪽 오른쪽을 쪼개서 재귀 돌린다.
        // 오른쪽이 사전순으로 앞서기 때문에 오른쪽 먼저 재귀 진행
        zoac(idx+1, right);
        zoac(left, idx -1 );
    }
}