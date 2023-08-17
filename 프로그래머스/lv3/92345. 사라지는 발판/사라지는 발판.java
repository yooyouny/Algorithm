class Solution {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static class Result{
        boolean win;// 승부여부에 따라 cnt 저장 값이 달라지므로 
        int cnt;
        Result(boolean win, int cnt){
            this.win = win;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Result result = dfs(board, aloc, bloc);
        return result.cnt;
    }
    private Result dfs(int[][] board, int[] aloc, int[] bloc){
        int r1 = aloc[0];
        int c1 = aloc[1];
        int r2 = bloc[0];
        int c2 = bloc[1];
        
        if(board[r1][c1] == 0)
            return new Result(false, 0); // 종료조건1 발판이 없어서 이동할 수 없어서 지는 경우
        
        board[r1][c1] = 0;// 해당 위치를 밟고 이동하면 발판이 사라짐
        
        int min_win = Integer.MAX_VALUE;// 이겼을때의 cnt 저장, 최솟값을 구해야하므로 max세팅 
        int max_lose = 0;// 졌을때의 cnt 저장, 최댓값 계산해야하므로 0으로 세팅 
        
        for(int i=0; i<4; i++){
            int nr = r1 + dr[i];
            int nc = c1 + dc[i];
            if(nr<0 || nc<0 || nr>= board.length || nc>=board[0].length) continue;// 보드밖이거나
            if(board[nr][nc] == 0) continue; // 발판이 없으면 이동 불가 
            
            Result result = dfs(board, bloc, new int[]{nr, nc});// 상대기준 
            if(result.win){// 상대방이 이겼으면 현재 플레이어는 짐
                max_lose = Math.max(max_lose, result.cnt + 1);// 다음 플레이어 횟수에서 현재 플레이어의 횟수를 더함
            }else{// 현재 플레이어가 이기는 경우 
                min_win = Math.min(min_win, result.cnt + 1);
                
            }
        }
        board[r1][c1] = 1;// 가능한 4방향의 모든 경우 탐색이 끝나면 다시 원상복귀시켜줌
        
        //이길 수 있는 경우가 하나라도 있는지 확인 
        if(min_win < Integer.MAX_VALUE){
            return new Result(true, min_win);
        }else{
            return new Result(false, max_lose);
        }
    }
}