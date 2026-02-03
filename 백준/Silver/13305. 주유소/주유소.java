import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] kmArr;
    static int[] L_Arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        kmArr = new int[N-1];
        L_Arr = new int[N];

        String[] kmInput = br.readLine().split(" ");
        for (int i = 0; i < kmInput.length; i++) {
            kmArr[i] = Integer.parseInt(kmInput[i]);
        }
        String[] LInput = br.readLine().split(" ");
        for (int i = 0; i < LInput.length; i++) {
            L_Arr[i] = Integer.parseInt(LInput[i]);
        }

        int total = 0;
        int nowIdx = 0;
        for (int i = 0; i < N-1; i++) {
            if (L_Arr[nowIdx] > L_Arr[i+1]) {
                total += L_Arr[nowIdx] * kmArr[i];
                nowIdx = i+1;
            } else {
                total += L_Arr[nowIdx] * kmArr[i];
            }
        }

        System.out.println(total);


    }
}