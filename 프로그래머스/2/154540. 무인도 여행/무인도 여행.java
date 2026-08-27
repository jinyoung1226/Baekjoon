import java.util.*;

class Solution {
    String[][] board;
    boolean[][] visited;
    List<Integer> result = new ArrayList<>();
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int[] solution(String[] maps) {
        board = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                board[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        
        System.out.println(Arrays.deepToString(board));
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals("X") && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        if (result.size() == 0) {
            return new int[]{-1};
        } else {
            Collections.sort(result);
            int[] arr = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                arr[i] = result.get(i);
            }
            return arr;
        }
    }
    
    public int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        visited[x][y] = true;
        q.add(new int[]{x, y, Integer.valueOf(board[x][y])});
    
        while (!q.isEmpty()) {
            int[] now = q.poll();
            result += now[2];
            
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length && !board[nextX][nextY].equals("X") && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY, Integer.valueOf(board[nextX][nextY])});
                }
            }
        }
        
        return result;
    }
}