import java.io.*;
import java.util.*;

public class Main {
    static int[][] db_arr = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        db_arr[0][0] = 1;
        db_arr[0][1] = 0;
        db_arr[1][0] = 0;
        db_arr[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            db_arr[i][0] = db_arr[i-1][0] + db_arr[i-2][0];
            db_arr[i][1] = db_arr[i-1][1] + db_arr[i-2][1];
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(db_arr[num][0] + " " + db_arr[num][1]);
        }

    }
}