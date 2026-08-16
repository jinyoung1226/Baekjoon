import java.util.*;

class Solution {
    String[][] board2;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        board2 = new String[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                board2[i][j] = String.valueOf(board[i].charAt(j));
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(startX, startY);
    }
    
    public int bfs(int x, int y) {
        // x, y, cost
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y, 0});
        int resultCost = -1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (board2[now[0]][now[1]].equals("G")) {
                resultCost = now[2];
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    int[] arrUpper = upper(now[0], now[1]);
                    if (arrUpper[2] == 1) {
                        continue;
                    } else {
                        q.add(new int[]{arrUpper[0], arrUpper[1], now[2] + 1});
                    }
                } else if (i == 1) {
                    int[] arrUnder = under(now[0], now[1]);
                    if (arrUnder[2] == 1) {
                        continue;
                    } else {
                        q.add(new int[]{arrUnder[0], arrUnder[1], now[2] + 1});
                    }
                } else if (i == 2) {
                    int[] arrLeft = left(now[0], now[1]);
                    if (arrLeft[2] == 1) {
                        continue;
                    } else {
                        q.add(new int[]{arrLeft[0], arrLeft[1], now[2] + 1});
                    }
                } else {
                    int[] arrRight = right(now[0], now[1]);
                    if (arrRight[2] == 1) {
                        continue;
                    } else {
                        q.add(new int[]{arrRight[0], arrRight[1], now[2] + 1});
                    }
                }
            }
        }
        
        return resultCost;
    }
    
    public int[] upper(int x, int y) {
        int nx = x;
        int ny = y;
        int resultX = 0;
        int resultY = 0;
        boolean flag = false;
        
        while (true) {
            nx = nx - 1;
            ny = ny;
            
            if (nx >= 0 && ny >= 0 && nx < board2.length && ny < board2[0].length) {
                if (board2[nx][ny].equals(".") || board2[nx][ny].equals("G") || board2[nx][ny].equals("R")) {
                    continue;
                } else {
                    if (!visited[nx + 1][ny]) {
                        resultX = nx + 1;
                        resultY = ny;
                        visited[resultX][resultY] = true;
                        flag = true;
                    }
                    break;
                }
            } else {
                if (!visited[nx + 1][ny]) {
                    resultX = nx + 1;
                    resultY = ny;
                    visited[resultX][resultY] = true;
                    flag = true;
                }
                break;
            }
        }
        
        if (flag) {
            return new int[]{resultX, resultY, 0};
        } else {
            return new int[]{resultX, resultY, 1};
        }
    }
    
    public int[] under(int x, int y) {
        int nx = x;
        int ny = y;
        int resultX = 0;
        int resultY = 0;
        boolean flag = false;
        
        while (true) {
            nx = nx + 1;
            ny = ny;
            
            if (nx >= 0 && ny >= 0 && nx < board2.length && ny < board2[0].length) {
                if (board2[nx][ny].equals(".") || board2[nx][ny].equals("G") || board2[nx][ny].equals("R")) {
                    continue;
                } else {
                    if (!visited[nx - 1][ny]) {
                        resultX = nx - 1;
                        resultY = ny;
                        visited[resultX][resultY] = true;
                        flag = true;
                    }
                    break;
                }
            } else {
                if (!visited[nx - 1][ny]) {
                    resultX = nx - 1;
                    resultY = ny;
                    visited[resultX][resultY] = true;
                    flag = true;
                }
                break;
            }
        }
        
        if (flag) {
            return new int[]{resultX, resultY, 0};
        } else {
            return new int[]{resultX, resultY, 1};
        }
    }
    
    public int[] left(int x, int y) {
        int nx = x;
        int ny = y;
        int resultX = 0;
        int resultY = 0;
        boolean flag = false;
        
        while (true) {
            nx = nx;
            ny = ny - 1;
            
            if (nx >= 0 && ny >= 0 && nx < board2.length && ny < board2[0].length) {
                if (board2[nx][ny].equals(".") || board2[nx][ny].equals("G") || board2[nx][ny].equals("R")) {
                    continue;
                } else {
                    if (!visited[nx][ny + 1]) {
                        resultX = nx;
                        resultY = ny + 1;
                        visited[resultX][resultY] = true;
                        flag = true;
                    }
                    break;
                }
            } else {
                if (!visited[nx][ny + 1]) {
                    resultX = nx;
                    resultY = ny + 1;
                    visited[resultX][resultY] = true;
                    flag = true;
                }
                break;
            }
        }
        
        if (flag) {
            return new int[]{resultX, resultY, 0};
        } else {
            return new int[]{resultX, resultY, 1};
        }
    }
    
    public int[] right(int x, int y) {
        int nx = x;
        int ny = y;
        int resultX = 0;
        int resultY = 0;
        boolean flag = false;
        
        while (true) {
            nx = nx;
            ny = ny + 1;
            
            if (nx >= 0 && ny >= 0 && nx < board2.length && ny < board2[0].length) {
                if (board2[nx][ny].equals(".") || board2[nx][ny].equals("G") || board2[nx][ny].equals("R")) {
                    continue;
                } else {
                    if (!visited[nx][ny - 1]) {
                        resultX = nx;
                        resultY = ny - 1;
                        visited[resultX][resultY] = true;
                        flag = true;
                    }
                    break;
                }
            } else {
                if (!visited[nx][ny - 1]) {
                    resultX = nx;
                    resultY = ny - 1;
                    visited[resultX][resultY] = true;
                    flag = true;
                }
                break;
            }
        }
        
        if (flag) {
            return new int[]{resultX, resultY, 0};
        } else {
            return new int[]{resultX, resultY, 1};
        }
    }
}