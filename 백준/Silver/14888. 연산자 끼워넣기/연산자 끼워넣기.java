import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Map<String, Boolean>> check;
    static List<String> result = new ArrayList<>();
    static String[] secondInput;
    static boolean[] flag;
    static BufferedWriter bw;
    static Integer Max;
    static Integer Min;
    static int flags = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        check = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        secondInput = br.readLine().split(" ");
        flag = new boolean[secondInput.length];

        String[] threeInput = br.readLine().split(" ");
        int[] operators = new int[4];
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(threeInput[i]);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operators[i]; j++) {
                Map<String, Boolean> map = new HashMap<>();
                if(i == 0) {
                    map.put("+", false);
                    check.add(map);
                } else if(i == 1) {
                    map.put("-", false);
                    check.add(map);
                } else if(i == 2) {
                    map.put("*", false);
                    check.add(map);
                } else {
                    map.put("/", false);
                    check.add(map);
                }
            }
        }
        result.add(secondInput[0]);
        flag[0] = true;
        backTracking(0);
        bw.write(Max + "\n");
        bw.write(Min + "\n");
        bw.flush();
    }

    private static void backTracking(int depth) throws IOException {
        if(depth == N - 1) {
            int realResult = Integer.parseInt(secondInput[0]);

            for (int i = 1; i < result.size(); i += 2) {
                if(result.get(i).equals("+")) {
                    realResult += Integer.parseInt(result.get(i + 1));
                } else if(result.get(i).equals("-")) {
                    realResult -= Integer.parseInt(result.get(i + 1));
                } else if(result.get(i).equals("*")) {
                    realResult *= Integer.parseInt(result.get(i + 1));
                } else if(result.get(i).equals("/")) {
                    if(realResult < 0) {
                        int N1 = Math.abs(realResult) / Integer.parseInt(result.get(i + 1));
                        int N2 = -N1;
                        realResult = N2;
                    } else {
                        realResult /= Integer.parseInt(result.get(i + 1));
                    }
                }
            }

            if(Max == null && Min == null) {
                Max = realResult;
                Min = realResult;
            } else if(realResult > Max) {
                Max = realResult;
            } else if(realResult < Min) {
                Min = realResult;
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if(check.get(i - 1).values().contains(false)) {

                String string = check.get(i - 1).keySet().iterator().next();
                check.get(i - 1).put(string, true);
                result.add(string);
                result.add(secondInput[flags]);
                flags++;

                backTracking(depth + 1);

                result.remove(result.size() - 1);
                result.remove(result.size() - 1);
                check.get(i - 1).put(string, false);
                flags--;
            }
        }

    }
}