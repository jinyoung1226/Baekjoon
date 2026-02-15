import java.io.*;
import java.util.*;

public class Main {

    static class Olympic {
        int num;
        int gold;
        int silver;
        int bronze;
        int cost;

        public Olympic (int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.cost = 0;
        }
    }

    static int N, K;
    static List<Olympic> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            String [] info = br.readLine().split(" ");
            list.add(new Olympic(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3])));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.gold != o2.gold) {
                return o2.gold - o1.gold;
            }
            if (o1.silver != o2.silver) {
                return o2.silver - o1.silver;
            }
            return o2.bronze - o1.bronze;
        });

        list.get(0).cost = 1;
        for (int i = 1; i < N; i++) {
            Olympic before = list.get(i-1);
            Olympic now = list.get(i);

            if (before.gold == now.gold && before.silver == now.silver && before.bronze == now.bronze) {
                now.cost = before.cost;
            } else {
                now.cost = i+1;
            }
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.num - o2.num;
        });

        System.out.println(list.get(K-1).cost);
    }
}