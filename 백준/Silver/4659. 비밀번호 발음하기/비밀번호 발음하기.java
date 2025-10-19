import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();

            if (str.equals("end")) {
                break;
            }

            // 모음 하나라도 포함하지 않으면
            if (!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o") && !str.contains("u")) {
                System.out.println("<" + str + ">" + " is not acceptable.");
                continue;
            }

            // 모음 3개 연속, 자음 3개 연속인지 체크
            int mo_count = 0;
            int ja_count = 0;
            boolean mo_check = false;
            boolean ja_check = false;
            boolean flag_2 = false;
            boolean flag_3 = false;

            for (char s : str.toCharArray()) {
                if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
                    mo_count++;
                    mo_check = true;
                    if (ja_check) {
                        ja_count = 0;
                        ja_check = false;
                    }
                } else {
                    ja_count++;
                    ja_check = true;
                    if (mo_check) {
                        mo_count = 0;
                        mo_check = false;
                    }
                }

                if (mo_count >= 3 || ja_count >= 3) {
                    System.out.println("<" + str + ">" + " is not acceptable.");
                    flag_2 = true;
                    break;
                }
            }

            if (flag_2) {
                continue;
            }

            char[] charArray = str.toCharArray();
            for (int i = 0; i < str.length() - 1; i++) {
                if(charArray[i] == charArray[i+1]) {
                    if ((charArray[i] == 'e' && charArray[i+1] == 'e') || (charArray[i] == 'o' && charArray[i+1] == 'o')) {
                        continue;
                    } else {
                        System.out.println("<" + str + ">" + " is not acceptable.");
                        flag_3 = true;
                        break;
                    }
                }
            }

            if (!flag_3) {
                System.out.println("<" + str + ">" + " is acceptable.");
            }
        }
    }
}