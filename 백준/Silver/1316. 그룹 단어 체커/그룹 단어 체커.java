import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < input.length(); j++) {
                if(!list.contains(input.charAt(j) + "")) {
                    list.add(input.charAt(j) + "");
                } else {
                    if(list.get(j-1).equals(input.charAt(j) + "")) {
                        list.add(input.charAt(j) + "");
                    } else {
                        count --;
                        break;
                    }
                }
            }
            count ++;
        }
        bw.write(count + "\n");
        bw.flush();
    }
}