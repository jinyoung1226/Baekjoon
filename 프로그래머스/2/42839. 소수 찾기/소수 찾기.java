import java.util.*;

class Solution {
    boolean[] visited;
    Integer[] result;
    int count = 0;
    String[] arr;
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        arr = new String[numbers.length()];
        visited = new boolean[arr.length];
        result = new Integer[arr.length];
        
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = String.valueOf(numbers.charAt(i));
        }
        
        for (int i = 1; i <= arr.length; i++) {
            permutation(0, arr.length, i);
        }
        
        return count;
    }
    
    public void permutation(int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                if (result[i] != null) {
                    sb.append(result[i]);
                }
            }
            if (isPrime(Integer.parseInt(sb.toString()))) {
                count++;
            }
            
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = Integer.parseInt(arr[i]);
                permutation(depth+1, n , r);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (set.contains(num)) {
            return false;
        }
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        set.add(num);
        return true;
    }
}