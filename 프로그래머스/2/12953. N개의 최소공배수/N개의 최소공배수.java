import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // 제일 큰 숫자를 기준으로 하나씩 곱해서 모든 배열을 체크해서 while문 돌리면 될듯.
        Arrays.sort(arr);
        int maxNumber = arr[arr.length - 1];
        int plusNum = maxNumber;
        System.out.println(maxNumber);
        
        // maxNumber를 기준으로 남은 수들로 나머지 연산 시, 0으로 되는지 체크하고 안되면 *2 해서 다시 돌리기
        while (true) {
            boolean allNumberPass = true;
            for (int i = 0; i < arr.length-1; i++) {
                if (maxNumber % arr[i] != 0) {
                    allNumberPass = false;
                    break;
                }
            }
            
            if (allNumberPass) {
                return maxNumber;
            } else {
                maxNumber += plusNum;
            }
        }
    }
}