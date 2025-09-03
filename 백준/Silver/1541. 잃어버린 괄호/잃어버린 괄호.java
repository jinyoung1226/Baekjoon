import java.io.*;

public class Main {
    static String[] data;
    static int total_result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        if (!s.contains("-")) {
            String[] data1 = s.split("\\+");
            int sub_total = 0;
            for (int i = 0; i < data1.length; i++) {
                sub_total += Integer.parseInt(data1[i]);
            }
            System.out.println(sub_total);
        } else {
            data = s.split("-");

            for (int i = 0; i < data.length; i++) {
                if (data[i].contains("+") && i == 0) {
                    String[] data1 = data[i].split("\\+");
                    int sub_total = 0;
                    for (int j = 0; j < data1.length; j++) {
                        sub_total += Integer.parseInt(data1[j]);
                    }
                    total_result += sub_total;
                }
                else if (data[i].contains("+") && i != 0) {
                    String[] data1 = data[i].split("\\+");
                    int sub_total = 0;
                    for (int j = 0; j < data1.length; j++) {
                        sub_total += Integer.parseInt(data1[j]);
                    }
                    total_result -= sub_total;
                } else if (i == 0 && !data[i].contains("+")) {
                    total_result += Integer.parseInt(data[i]);
                } else {
                    total_result -= Integer.parseInt(data[i]);
                }
            }

            System.out.println(total_result);
        }
    }
}