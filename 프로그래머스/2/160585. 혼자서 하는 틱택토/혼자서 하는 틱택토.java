import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(String[] board) {
        int fail = 0;
        int success = 1;
        
        String chars = Arrays.asList(board).stream()
            .reduce("", String::concat)
            .replace(".", "");
        
        
        char[][] charBoard = new char[3][3];
        charBoard[0] = board[0].toCharArray();
        charBoard[1] = board[1].toCharArray();
        charBoard[2] = board[2].toCharArray();  
        
        boolean oWin = isWin(charBoard, "OOO");
        boolean xWin = isWin(charBoard, "XXX");

        long oCnt = chars.chars().filter(c -> c == 'O').count();
        long xCnt = chars.chars().filter(c -> c == 'X').count();
        
        if(xCnt > oCnt)
            return fail;
        
        if(oCnt > xCnt + 1)
            return fail;
        
        if(oWin && xCnt >= oCnt)
            return fail;
        
        if(xWin && oCnt > xCnt)
            return fail;
        
        return success;
    }
    private boolean isWin(char[][] board, String success){
        // 가로
        for(int i=0; i<3; i++){
            String s = "";
            for(int j=0; j<3; j++){
                s += board[i][j];
            }
            if(s.equals(success)) return true;
        }
        
        //세로
        for(int i=0; i<3; i++){
            String s = "";
            for(int j=0; j<3; j++){
                s += board[j][i];
            }
            if(s.equals(success)) return true;
        }
        
        //대각선
        String forward = "";
        String reverse = "";
        for(int i=0; i<3; i++){
            forward += board[i][i];
            reverse += board[i][2-i];
        }
        if(forward.equals(success)) return true;
        if(reverse.equals(success)) return true;
        
        return false;
    }
}