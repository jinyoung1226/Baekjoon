import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, List<String>> map = new HashMap<>();
        double total = 0;
        double total1 = 0;
        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], new ArrayList<>(Arrays.asList(input[1], input[2])));
            switch (map.get(input[0]).get(1)) {
                case ("A+"):
                    double sum1 = Double.parseDouble(map.get(input[0]).get(0)) * 4.5;
                    total += sum1;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("A0"):
                    double sum2 = Double.parseDouble(map.get(input[0]).get(0)) * 4.0;
                    total += sum2;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("B+"):
                    double sum3 = Double.parseDouble(map.get(input[0]).get(0)) * 3.5;
                    total += sum3;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("B0"):
                    double sum4 = Double.parseDouble(map.get(input[0]).get(0)) * 3.0;
                    total += sum4;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("C+"):
                    double sum5 = Double.parseDouble(map.get(input[0]).get(0)) * 2.5;
                    total += sum5;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("C0"):
                    double sum6 = Double.parseDouble(map.get(input[0]).get(0)) * 2.0;
                    total += sum6;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("D+"):
                    double sum7 = Double.parseDouble(map.get(input[0]).get(0)) * 1.5;
                    total += sum7;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("D0"):
                    double sum8 = Double.parseDouble(map.get(input[0]).get(0));
                    total += sum8;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));
                    break;
                case ("F"):
                    double sum9 = Double.parseDouble(map.get(input[0]).get(0)) * 0;
                    total += sum9;
                    total1 += Double.parseDouble(map.get(input[0]).get(0));

                    break;
                case ("P"):
                    break;
            }
        }
        if(total == 0) {
            bw.write( total + "\n");
        } else  {
            bw.write((total / total1) + "\n");
        }
        bw.flush();
    }
}