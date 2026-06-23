import java.util.*;

class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[4][11][11];
        int[] start = new int[]{5,5};
        int count = 0;
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
        map.put('R', new int[]{0, 1});
        map.put('L', new int[]{0, -1});
        
        for (char ch : dirs.toCharArray()) {
            int[] operation = map.get(ch);
            int tempX = start[0] + operation[0];
            int tempY = start[1] + operation[1];
            if (tempX >= 0 && tempY >= 0 && tempX <= 10 && tempY <= 10) {
                if (ch == 'U') {
                    if (!visited[0][start[0]][start[1]] && !visited[1][tempX][tempY]) {
                        visited[0][start[0]][start[1]] = true;
                        visited[1][tempX][tempY] = true;
                        start = new int[]{tempX, tempY};
                        count++;
                    } else {
                        start = new int[]{tempX, tempY};
                    }
                } else if (ch == 'D') {
                    if (!visited[1][start[0]][start[1]] && !visited[0][tempX][tempY]) {
                        visited[1][start[0]][start[1]] = true;
                        visited[0][tempX][tempY] = true;
                        start = new int[]{tempX, tempY};
                        count++;
                    } else {
                        start = new int[]{tempX, tempY};
                    }
                } else if (ch == 'R') {
                    if (!visited[2][start[0]][start[1]] && !visited[3][tempX][tempY]) {
                        visited[2][start[0]][start[1]] = true;
                        visited[3][tempX][tempY] = true;
                        start = new int[]{tempX, tempY};
                        count++;
                    } else {
                        start = new int[]{tempX, tempY};
                    }
                } else {
                    if (!visited[3][start[0]][start[1]] && !visited[2][tempX][tempY]) {
                        visited[3][start[0]][start[1]] = true;
                        visited[2][tempX][tempY] = true;
                        start = new int[]{tempX, tempY};
                        count++;
                    } else {
                        start = new int[]{tempX, tempY};
                    }
                }
            }
        }
        
        return count;
    }
}