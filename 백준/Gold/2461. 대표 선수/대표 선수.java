import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static class Node {
        int skill;
        int school;

        public Node (int skill, int school) {
            this.skill = skill;
            this.school = school;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] skills = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(skills[j]);
            }

            int[] sort = arr[i];
            Arrays.sort(sort);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.skill - o2.skill;
        });
        int[] schoolIdx = new int[N];
        int skillMax = 0;
        for (int i = 0; i < N; i++) {
            pq.add(new Node(arr[i][0], i));
            skillMax = Math.max(skillMax, arr[i][0]);
        }

        int result = Integer.MAX_VALUE;
        while(true) {
            Node now = pq.poll();
            int skill = now.skill;
            int school = now.school;

            result = Math.min(result, skillMax - skill);

            schoolIdx[school]++;
            if (schoolIdx[school] == M) break;

            pq.add(new Node(arr[school][schoolIdx[school]], school));
            skillMax = Math.max(skillMax, arr[school][schoolIdx[school]]);
        }
        System.out.println(result);

    }
}