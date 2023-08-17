class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int rowLen = board.length;
        int columnLen = board[0].length;
        int[][] building = new int[rowLen + 1][columnLen + 1];
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3] + 1;
            int c2 = s[4] + 1;
            int degree = s[0] == 1 ? -s[5] : s[5];
            
            building[r1][c1] += degree;
            building[r1][c2] -= degree;
            building[r2][c1] -= degree;
            building[r2][c2] += degree;
        }
        
        for(int i=0; i<rowLen; i++){
            for(int j=1; j<columnLen; j++){
                building[i][j] += building[i][j-1];
            }
        }
        
        for(int i=1; i<rowLen; i++){
            for(int j=0; j<columnLen; j++){
                building[i][j] += building[i-1][j];
            }
        }
        
        for(int i=0; i<rowLen; i++){
            for(int j=0; j<columnLen; j++){
                if(board[i][j] + building[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}