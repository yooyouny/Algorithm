import java.util.*;
class Point {
    long x;
    long y;
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    long[] result;
    public Boolean findIntersection(int[] first, int[] second){
        
        long a = first[0];
        long b = first[1];
        long e = first[2];
        long c = second[0];
        long d = second[1];
        long f = second[2];
        
        long adbc = (a*d) - (b*c);
        long bfed = (b*f) - (e*d);
        long ecaf = (e*c) - (a*f);
        
        if(adbc == 0){
            return false;
        }else if(bfed % adbc != 0 || ecaf % adbc != 0){
            return false;
        }else{
            result[0] = bfed / adbc;
            result[1] = ecaf / adbc;
            return true;
        }
    }
    
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();
        result = new long[2];
        
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE; 
        long maxY = Long.MIN_VALUE;
        
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if(findIntersection(line[i], line[j])) //정수로 표현된 교점 좌표 구하기
                    points.add(new Point(result[0], result[1]));
            }
        }
        
        for(Point p : points){
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }
        
        boolean[][] stars = new boolean[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        
        for(Point p : points){
            int x = (int)(p.x - minX);
            int y = (int)(maxY - p.y);
            stars[y][x] = true;
        }
        
        String[] answer = new String[stars.length];
        int idx = 0;
        
        for(boolean[] star : stars){
            StringBuilder sb = new StringBuilder();
            for(boolean chk : star){
                if(chk)
                    sb.append("*");
                else
                    sb.append(".");
            }
            answer[idx++] = sb.toString();
        }
        return answer;
    }
}