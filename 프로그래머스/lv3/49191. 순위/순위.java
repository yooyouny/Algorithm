import java.util.*;
class Solution {
    static boolean[][] board;
    private int getRow(int r, int n, boolean[] visited){
        int cnt = 1;
        for(int i=0; i<n; i++){
            if(!board[r][i] || visited[i]) continue;
            visited[i] = true;
            cnt += getRow(i, n, visited);
        }
        return cnt;
    }
    private int getColumn(int c, int n, boolean[] visited){
        int cnt = 1;
        for(int i=0; i<n; i++){
            if(!board[i][c] || visited[i]) continue;
            visited[i] = true;
            cnt += getColumn(i, n, visited);
        }
        return cnt;
    }
    public int solution(int n, int[][] results) {
        board = new boolean[n][n];
        for (int[] result : results) {
            int u = result[0] - 1;
            int v = result[1] - 1;
            board[u][v] = true;
        }
        
        int count = 0;
        for (int i=0; i<n; i++){
            int win_cnt = getRow(i, n, new boolean[n]) - 1;
            int lose_cnt = getColumn(i, n, new boolean[n]) - 1;
            if (win_cnt + lose_cnt + 1 == n)
                count++;
        }

        return count;
    }
}