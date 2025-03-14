import java.io.*;

public class Main {

    static int update_array[];
    static int check_array[];
    static int checkSecret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // DNA 문자열 길이 S, 부분문자열 길이 P
        String[] data = br.readLine().split(" ");
        int S = Integer.parseInt(data[0]);
        int P = Integer.parseInt(data[1]);

        // 비밀번호 종류 수
        int count = 0;

        // 임의 DNA 문자, 배열로 만들기
        String DNA = br.readLine();
        char[] DNA_array = new char[DNA.length()];
        for (int i = 0; i < DNA.length(); i++) {
            DNA_array[i] = DNA.charAt(i);
        }

        // 체크배열과 업데이트 배열,체크 시크릿
        check_array = new int[4];
        update_array = new int[4];


        // 부분 문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 최소 개수
        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            check_array[i] = Integer.parseInt(data1[i]);
            if(check_array[i] == 0){
                checkSecret++;
            }
        }

        // 첫 P길이만 체크
        for(int i = 0; i < P; i++){
            Add(DNA_array[i]);
        }

        if(checkSecret == 4) {
            count++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(DNA_array[i]);
            Remove(DNA_array[j]);
            if(checkSecret == 4){
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();


    }

    private static void Add(char c){
        switch (c) {
            case 'A':
                update_array[0]++;
                if(update_array[0] == check_array[0]){
                    checkSecret++;
                }
                break;

            case 'C':
                update_array[1]++;
                if(update_array[1] == check_array[1]){
                    checkSecret++;
                }
                break;

            case 'G':
                update_array[2]++;
                if(update_array[2] == check_array[2]){
                    checkSecret++;
                }
                break;

            case 'T':
                update_array[3]++;
                if(update_array[3] == check_array[3]){
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c){
        switch (c) {
            case 'A':
                if(update_array[0] == check_array[0]){
                    checkSecret--;
                }
                update_array[0]--;
                break;

            case 'C':
                if(update_array[1] == check_array[1]){
                    checkSecret--;
                }
                update_array[1]--;
                break;

            case 'G':
                if(update_array[2] == check_array[2]){
                    checkSecret--;
                }
                update_array[2]--;
                break;

            case 'T':
                if(update_array[3] == check_array[3]){
                    checkSecret--;
                }
                update_array[3]--;
                break;
        }
    }
}