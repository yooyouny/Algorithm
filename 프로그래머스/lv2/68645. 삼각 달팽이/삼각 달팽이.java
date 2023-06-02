import java.util.*;
class Solution {
    public int[] solution(int n) {
        int size = n * (n+1) / 2;
        int[] answer = new int[size];
        int[][] snail = new int[n][n];
        
        int num = 1;
        int x = 0, y = 0, idx = 0;
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        
        while(num <= size){
            snail[y][x] = num;
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            if(nx<0 || ny <0 || nx>=n || ny>=n || snail[ny][nx] != 0){
                idx = (idx + 1) % 3;
                y = y + dy[idx];
                x = x + dx[idx];
            }else{
                y = ny;
                x = nx;
            }   
            num++;
        }
        answer = Arrays.stream(snail)
                    .flatMapToInt(Arrays::stream)
                    .filter(value -> value != 0)
                    .toArray();
        return answer;
    }
}