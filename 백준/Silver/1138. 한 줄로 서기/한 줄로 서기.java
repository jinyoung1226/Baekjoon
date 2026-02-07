import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] infoArr;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        result = new int[N];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        infoArr = new int[N+1];
        for (int i = 1; i < infoArr.length; i++) {
            infoArr[i] = Integer.parseInt(data[i-1]);
        }


        for (int i = 1; i < infoArr.length; i++) {

            int height = i;
            int nowCount = 0;
            int idx = 0;

            while (nowCount != infoArr[height]) {
                if (result[idx] > height) {
                    nowCount++;
                }
                idx++;
            }


            while (result[idx] != Integer.MAX_VALUE) {
                idx++;
            }

            result[idx] = height;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);



    }
}