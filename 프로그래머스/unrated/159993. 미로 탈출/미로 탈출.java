import java.util.*;
class Solution {
    class Point{
        int r;
        int c;
        int time;
        public Point(){}
        public Point(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
        public void setPoint(Point p, int r, int c, int time){
            p.r = r;
            p.c = c;
            p.time = time;
        }
        
    }
    static char[][] maze;
    public int solution(String[] maps) {
        int answer = Integer.MAX_VALUE;
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        int R = maps.length;
        int C = maps[0].length();
        maze = new char[R][C];
        
        Point start = new Point();
        Point exit = new Point();
        Point lever = new Point();
        init(maps, start, exit, lever);
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(start);
        visited[start.r][start.c] = true;
        boolean on = false;
        
        while(!queue.isEmpty()){
            Point get = queue.poll();
            int r = get.r;
            int c = get.c;
            int time = get.time;
            if(r == lever.r && c == lever.c){
                answer = time;
                on = true;
                break;
            }
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(maze[nr][nc] == 'X' || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, time + 1));
            }   
        }
        
        if(!on) return -1;
        
        queue = new LinkedList<>();
        queue.add(new Point(lever.r, lever.c, answer));
        visited = new boolean[R][C];
        visited[lever.r][lever.c] = true;
        
        while(!queue.isEmpty()){
            Point get = queue.poll();
            int r = get.r;
            int c = get.c;
            int time = get.time;
            if(r == exit.r && c == exit.c){
                return time;
            }
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(maze[nr][nc] == 'X' || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, time + 1));
            }   
        }
        
        return -1;
    }
    private void init(String[] maps, Point start, Point exit, Point lever){
        for(int i=0; i<maps.length; i++){
            maze[i] = maps[i].toCharArray();
            for(int j=0; j<maze[i].length; j++){
                switch(maze[i][j]){
                        case 'S' -> {
                            start.setPoint(start, i, j, 0);
                        }
                        case 'E' -> {
                            exit.setPoint(exit, i, j, 0);
                        }
                        case 'L' -> {
                            lever.setPoint(lever, i, j, 0);
                        }
                        default -> {}
                }
            }
        }
    }
}