import java.util.*;
class Point{
    long x;
    long y;
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}
class Solution{
    List<Point> points;

    private void getPoint(int[] first, int[] second){
        long a = first[0];
		long b = first[1];
		long e = first[2];
		long c = second[0];
		long d = second[1];
		long f = second[2];
        
        long adbc = (a*d) - (b*c);
		long bfed = (b*f) - (e*d);
		long ecaf = (e*c) - (a*f);

        if(adbc == 0 || bfed % adbc != 0 || ecaf % adbc != 0) return;
        
        long x = bfed / adbc;
        long y = ecaf / adbc;
        points.add(new Point(x, y));
        
    }
    private String[][] printStar(){
		long minX = Long.MAX_VALUE;
		long minY = Long.MAX_VALUE;
		long maxX = Long.MIN_VALUE;
		long maxY = Long.MIN_VALUE;

		for(Point p : points){
			minX = Math.min(minX, p.x);
			minY = Math.min(minY, p.y);
			maxX = Math.max(maxX, p.x);
			maxY = Math.max(maxY, p.y);
		}
        
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        
        String[][] result = new String[height][width];
        
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                result[i][j] = ".";
            }
        }
        
        for(Point p : points){
            result[(int)(maxY - p.y)][(int)(p.x - minX)] = "*";
        }
        
        return result;
    }
    public String[] solution(int[][] line) {
        
        points = new ArrayList<>();
        for(int i=0; i<line.length-1; i++){
            for(int j=i+1; j<line.length; j++){
                getPoint(line[i], line[j]);
            }
        }
        String[][] stars = printStar();
    
        String[] answer = new String[stars.length];
        int idx = 0;
        for(int i=0; i<stars.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<stars[i].length; j++){
                sb.append(stars[i][j]);
            }
            answer[idx++] = sb.toString();
        }
        
        return answer;
    }
}