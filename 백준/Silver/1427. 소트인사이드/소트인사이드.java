import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int[] array = new int[N.length()];

        for(int i = 0; i < N.length(); i++) {
            array[i] = Integer.parseInt(N.substring(i, i+1));
        }

        for(int i = 0; i < N.length(); i++) {
            int Max = i;

            for(int j = i + 1; j < N.length(); j++) {
                if(array[j] > array[Max]) {
                    Max = j;
                }
            }

            int temp = array[i];
            array[i] = array[Max];
            array[Max] = temp;
        }

        for (int i : array) {
            bw.write(i + "");
        }
        bw.flush();
    }
}