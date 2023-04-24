import java.util.*;
class Solution {
    public int[] solution(int n) {
        int size = (n+1) * n / 2; 
        int[] answer = new int[size];
        int idx = 0;
        int[][] snail = new int[n][n];
        
        int[] dx = {0, 1, -1}; //아래, 오른쪽, 대각선 위 순으로 진행 
        int[] dy = {1, 0, -1};
        
        int num = 1;
        int y = 0, x = 0, nx = 0, ny = 0, angle = 0;
        
        while(num<=size){
            snail[y][x] = num;
            ny = y + dy[angle];
            nx = x + dx[angle];
            num++;
            
            if(0 <= ny && ny < n && 0 <= nx && nx <= ny && snail[ny][nx] == 0){
                y = ny;
                x = nx;
            }else{
                angle = (angle + 1) % 3; 
                y = y + dy[angle];
                x = x + dx[angle];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(snail[i][j] == 0)
                    break;
                else
                    answer[idx++] = snail[i][j];
            }
        }
        return answer;
    }
}