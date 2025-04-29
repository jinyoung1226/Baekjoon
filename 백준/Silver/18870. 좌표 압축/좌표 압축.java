import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] array = new int[n];//원본 배열
        int[] arraySort = new int[n];//정렬된 배열
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();//압축할 map
 
        //배열 입력
        for(int i=0; i<n; i++){
            array[i] = arraySort[i] = sc.nextInt();
        }
 
        //배열 정렬
        Arrays.sort(arraySort);
 
 
        //배열의 압축값을 map에 저장
        int rank = 0;
 
        for(int value : arraySort){
            if(!rankMap.containsKey(value)){
                rankMap.put(value,rank);
                rank++;
            }
        }
 
        //원본 배열의 순서대로 해당 압축 배열을 출력
        StringBuilder sb = new StringBuilder();
        for(int value : array){
            sb.append(rankMap.get(value)).append(' ');
        }
 
        System.out.println(sb);
    }
}