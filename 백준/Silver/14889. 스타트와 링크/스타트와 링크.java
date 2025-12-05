import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] table;
    static int[] star_team;
    static int[] link_team;
    static int[] member;
    static boolean[] visited;
    static int[] check_star_team;
    static int[] check_link_team;

    static int star_team_count = 0;
    static int link_team_count = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        table = new int[N+1][N+1];
        star_team = new int[N/2];
        link_team = new int[N/2];
        member = new int[N];
        visited = new boolean[N+1];
        check_star_team = new int[2];
        check_link_team = new int[2];


        // 멤버 배열 세팅 (1 ~ N)
        for (int i = 0; i < N; i++) {
            member[i] = i+1;
        }

        // 능력치 테이블 세팅
        for (int i = 1; i <= N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(data[j-1]);
            }
        }

        team_combination(0,0);
        System.out.println(min);
    }

    static void team_combination(int start, int depth) {
        if (depth == N/2) {
            makeLinkTeam();

            star_calculate_table(star_team, 0, 0);
            link_calculate_table(link_team, 0, 0);

            int result = Math.abs(star_team_count - link_team_count);
            min = Math.min(result, min);
            star_team_count = 0;
            link_team_count = 0;
            return;
        }


        for (int i = start; i < member.length; i++) {
            star_team[depth] = member[i];
            visited[i+1] = true;
            team_combination(i + 1, depth + 1);
            visited[i+1] = false;
        }
    }

    static void makeLinkTeam() {
        int idx = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                link_team[idx] = i;
                idx++;
            }
        }
    }

    static void star_calculate_table(int[] team, int start, int depth) {
        if (depth == 2) {
            star_team_count += table[check_star_team[0]][check_star_team[1]];
            star_team_count += table[check_star_team[1]][check_star_team[0]];
            return;
        }
        
        for (int i = start; i < team.length; i++) {
            check_star_team[depth] = star_team[i];
            star_calculate_table(team, i+1, depth+1);
        }
    }

    static void link_calculate_table(int[] team, int start, int depth) {
        if (depth == 2) {
            link_team_count += table[check_link_team[0]][check_link_team[1]];
            link_team_count += table[check_link_team[1]][check_link_team[0]];
            return;
        }

        for (int i = start; i < team.length; i++) {
            check_link_team[depth] = link_team[i];
            link_calculate_table(team, i+1, depth+1);
        }
    }
}