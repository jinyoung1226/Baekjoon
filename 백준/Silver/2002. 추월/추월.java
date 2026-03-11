import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] outArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int num = 1;
        for (int i = 0; i < N; i++) {
            String carNum = br.readLine();
            map.put(carNum, num++);
        }

        outArr = new int[N];
        for (int i = 0; i < N; i++) {
            String carNum = br.readLine();
            int order = map.get(carNum);

            outArr[i] = order;
        }


        int resultCount = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (outArr[i] > outArr[j]) {
                    resultCount++;
                    break;
                }
            }
        }

        System.out.println(resultCount);


    }
}