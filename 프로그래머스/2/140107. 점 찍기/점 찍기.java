import java.util.*;
import java.math.*;
class Solution {
    // d^2 >= x^2 + y^2 원의방정식 활용 
    // y = Math.sqrt(d * d - x * x) 양의 방정식 
    public long solution(long k, long d) {
        long answer = 0;
        for(long x=0; x<=d; x+=k){
            long y = (long) Math.sqrt(d * d - x * x);
            answer += y/k + 1;
        }
        return answer;
    }
}