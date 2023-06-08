import java.util.*;
class Solution {
    private boolean isValid(int mid, int[] rocks, int n){
        int previous = 0;
        int cnt = 0;
        for(int rock : rocks){
            if(rock - previous < mid){
                cnt++;
            }else{
                previous = rock;
            }
        }
        return cnt <= n;
    }
    public int solution(int distance, int[] rocks, int n) {

        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance;
        
        while(start<=end){
            int mid = (start + end) / 2;
            
            if(isValid(mid, rocks, n)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return end;
    }
}