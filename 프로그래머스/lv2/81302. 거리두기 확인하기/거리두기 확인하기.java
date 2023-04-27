import java.util.*;
class Solution {
    public boolean bfs(String[] place, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y))
                    continue;
                
                int direction = Math.abs(nx - x) + Math.abs(ny - y);
                
                if(direction <= 2 && place[nx].charAt(ny) == 'P')
                    return false;
                else if(direction < 2 && place[nx].charAt(ny) == 'O')
                    queue.offer(new int[] {nx, ny});
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            String[] place = places[i];
            boolean result = true;
            
            for(int x=0; x<5; x++){
                for(int y=0; y<5; y++){
                    if(place[x].charAt(y) == 'P'){
                        if(!bfs(place, x, y))
                            result = false;
                    }
                }
            }
            answer[i] = result ? 1 : 0;
        }
        
        return answer;
    }
}