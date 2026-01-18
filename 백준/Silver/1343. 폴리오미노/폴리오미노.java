import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        while (str.contains("XXXX")) {
            str = str.replace("XXXX", "AAAA");
        }

        while (str.contains("XX")) {
            str = str.replace("XX", "BB");
        }

        if (str.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(str);
        }

    }
}