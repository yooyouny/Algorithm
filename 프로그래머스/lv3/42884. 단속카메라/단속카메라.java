import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // 고속도로에서 나간 기준으로 정렬 
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        
        int point = 0;
        for(int[] route : routes){
            int start = route[0];
            int end = route[1];
            
            if(start <= point && end >= point) continue;
            point = end;
            answer++;
        }
        
        return answer;
    }
}