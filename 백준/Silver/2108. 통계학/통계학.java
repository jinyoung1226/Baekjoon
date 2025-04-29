import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arrSort = new int[N];
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = arrSort[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += arr[i];
        }
        double average = total / (double) N;
        bw.write((int) Math.round(average) + "\n");

        // 중앙값
        Arrays.sort(arrSort);
        int index = 0;
        for (int i = 0; i < N/2; i++) {
            index++;
        }
        bw.write(arrSort[index] + "\n");

        // 최빈값
        for (int num : arr) {
            if(!countMap.containsKey(num)) {
                countMap.put(num,1);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        int maxCount = 0;
        for (int value : countMap.values()) {
            if(value > maxCount) {
                maxCount = value;
            }
        }

        List<Integer> maxNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if(entry.getValue() == maxCount) {
                maxNumbers.add(entry.getKey());
            }
        }
        if(maxNumbers.size() > 1) {
            Collections.sort(maxNumbers);
            bw.write(maxNumbers.get(1) + "\n");
        } else {
            bw.write(maxNumbers.get(0) + "\n");
        }

        // 범위
        int min = arrSort[0];
        int max = arrSort[arrSort.length - 1];
        bw.write(max-min + "\n");
        bw.flush();
    }
}