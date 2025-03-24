class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] di = {0, 0, 1, -1, -1, 1, -1, 1};
        int[] dj = {1, -1,0, 0, -1, 1, 1, -1};
        boolean[][] chk = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    chk[i][j] = true;
                    for(int ni=0; ni<8; ni++){
                        for(int nj=0; nj<8; nj++){
                            int ri = i + di[ni];
                            int rj = j + dj[nj];
                            if(ri<0 || rj<0 || ri>=n || rj>=n) continue;
                            chk[ri][rj] = true;
                        }
                    }
                }
            }
        }
        return getCnt(chk);
    }
    public int getCnt(boolean[][] chk){
        int result = 0;
        for(int i=0; i<chk.length; i++){
            for(int j=0; j<chk.length; j++){
                if(chk[i][j] == false) result++;
            }
        }
        return result;
    }
}