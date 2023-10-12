import java.util.*;
class Solution {

    public long solution(int r1, int r2) {
        long answer = 0;
        // x^2 + y^2 = r^2
        for(int x = 1; x <= r2 ; x++){// x값을 증가시켜가며 y 점의 개수 구하기 
            double y2 = Math.sqrt(Math.pow(r2,2) - Math.pow(x,2));
            double y1 = Math.sqrt(Math.pow(r1,2) - Math.pow(x,2));
            answer += ( (long)y2 - (long)Math.ceil(y1) + 1);
        }
        answer *= 4;
        
        return answer;
    }
    
}