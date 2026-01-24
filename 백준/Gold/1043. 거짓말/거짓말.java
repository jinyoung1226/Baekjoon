import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static List<Integer> list;
    static List<String[]>[] party;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기 + 이야기의 진실을 아는 사람 수와 번호 입력 받기
        String[] input = br.readLine().split(" ");
        String[] truthPeople = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 파티 관리 리스트와 집합 배열 초기화
        party = new List[M];
        parent = new int[N+1];
        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            party[i].add(br.readLine().split(" "));
        }
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 이야기의 진실을 아는 사람이 0명이면 바로 파티의 수로 반환
        // 아니면 아는 사람의 번호를 set에 보관
        if (truthPeople[0].equals("0")) {
            System.out.println(M);
            return;
        } else {
            int num = Integer.parseInt(truthPeople[0]);
            for (int i = 1; i <= num; i++) {
                list.add(Integer.parseInt(truthPeople[i]));
            }
        }

        for (int i = 0; i < M; i++) {
            String[] data = party[i].get(0);
            if (data[0].equals("1")) {
                continue;
            }

            int partyNum = Integer.parseInt(data[0]);
            for (int j = 1; j < partyNum; j++) {
                union(Integer.parseInt(data[j]), Integer.parseInt(data[j+1]));
            }
        }
        
        for (int i = 0; i < M; i++) {
            String[] data = party[i].get(0);
            int num = Integer.parseInt(data[0]);
            boolean check = true;

            for (int j = 1; j <= num; j++) {
                for (Integer truth : list) {
                    if (find(truth) == find(Integer.parseInt(data[j]))) {
                        check = false;
                    }
                }
            }

            if (check) {
                count++;
            }


        }

        System.out.println(count);
    }

    static int find (int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union (int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx > ny) {
            parent[nx] = ny;
        } else {
            parent[ny] = nx;
        }
    }
}