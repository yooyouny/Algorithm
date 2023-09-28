import java.util.*;
class Solution {
    class Point{
        int r;
        int c;
        int d;
        int cost;
        public Point(int r, int c, int d, int cost){
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][4];
        int[] dr = {-1, 0, 1, 0}; //상우하좌
        int[] dc = {0, 1, 0 ,-1};

        queue.add(new Point(0, 0, -1, 0));
   
        
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int r = point.r;
            int c = point.c;
            int d = point.d;
            int nowCost = point.cost;
            
            if(r == N-1 && c == N-1){
                answer = Math.min(answer, nowCost);
            }
            
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nd = i;
                int newCost = nowCost;

                if(0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] != 1){
                    if(nd == d || d == -1){
                        newCost += 100;
                    }else{
                        newCost += 600;
                    }
                    if(!visited[nr][nc][nd] || board[nr][nc] >= newCost){
                    queue.add(new Point(nr, nc, nd, newCost));
                    visited[nr][nc][nd] = true;
                    board[nr][nc] = newCost;
                    }
                }
            }
        }
        
        return answer;
    }
}