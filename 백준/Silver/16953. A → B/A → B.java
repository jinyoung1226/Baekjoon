import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int A = Integer.parseInt(data[0]);
        int B = Integer.parseInt(data[1]);

        int count = 0;
        while (B != A) {
            if (B < A) {
                System.out.println("-1");
                return;
            }

            if (B % 10 == 1) {
                B /= 10;
                count++;
            }else if (B % 2 == 0) {
                B = B / 2;
                count++;
            } else {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(count + 1);


    }
}