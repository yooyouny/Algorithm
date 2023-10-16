import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};// 상하좌우
    static int[] dc = {0, 0, -1, 1};
    static int R, C;
    public int solution(String[] board) {
        R = board.length;
        C = board[0].length();
        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int startR = 0;
        int startC = 0;
        
        for(int i=0; i<R; i++){
            map[i] = board[i].toCharArray();
            for(int j=0; j<C; j++){
                if(map[i][j] == 'R'){
                    startR = i;
                    startC = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        
        while(!queue.isEmpty()){
            int[] before = queue.poll();
            int r = before[0];
            int c = before[1];
            int m = before[2];
            if(map[r][c] == 'G'){
                answer = Math.min(answer, m);
                break;
            }
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
                if(map[nr][nc] == 'D') continue;
                //int[] newPoint = movePoint(map, nr, nc, i, R, C);
                while(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 'D') {
                    nr += dr[i];
                    nc += dc[i];
                }
                nr -= dr[i];
                nc -= dc[i];
                
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, m+1});
            }   
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}