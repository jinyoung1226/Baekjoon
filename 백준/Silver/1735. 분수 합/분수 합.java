import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data1 = br.readLine().split(" ");
        String[] data2 = br.readLine().split(" ");

        int first_bunja = Integer.parseInt(data1[0]);
        int first_bunmo = Integer.parseInt(data1[1]);

        int second_bunja = Integer.parseInt(data2[0]);
        int second_bunmo = Integer.parseInt(data2[1]);

        int[] first_arr = make_bunsu(first_bunja, first_bunmo);
        int[] second_arr = make_bunsu(second_bunja, second_bunmo);

        int real_bunmo = first_arr[1] * second_arr[1];
        int real_bunja = (first_arr[0] * second_arr[1]) + (second_arr[0] * first_arr[1]);

        int[] real_arr = make_bunsu(real_bunja, real_bunmo);
        System.out.println(real_arr[0] + " " + real_arr[1]);

    }

    static int[] make_bunsu(int bunja, int bunmo) {
        boolean flag = true;

        while (flag) {
            List<Integer> list = new ArrayList<>();
            for (int i = bunja; i >= 2; i--) {
                if (bunja % i == 0) {
                    list.add(i);
                }
            }

            int division_num = 0;
            for (Integer i : list) {
                if (bunmo % i == 0 ) {
                    division_num = i;
                    break;
                }
            }

            if (division_num == 0) {
                flag = false;
                break;
            }

            bunja = bunja / division_num;
            bunmo = bunmo / division_num;
        }

        int[] arr = {bunja, bunmo};

        return arr;
    }
}