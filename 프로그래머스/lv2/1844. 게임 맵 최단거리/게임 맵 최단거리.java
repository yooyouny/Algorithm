import java.util.*;
class Solution {
    static int answer;
    public void bfs(int[][] maps, int r, int c){
        int[] dr = {1,-1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        maps[r][c] = 1;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            r = poll[0];
            c = poll[1];
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && maps[nr][nc] == 1){
                    maps[nr][nc] = maps[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
    }
    public int solution(int[][] maps) {
        int r = maps.length - 1;
        int c = maps[0].length - 1;
        
        bfs(maps, 0, 0);
        
        return maps[r][c] == 1 ? -1 : maps[r][c];
    }
}