import java.math.*;
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1, right = -1;
        for(int num : stones){
            right = Math.max(num, right);
        }
        
        while(left<=right){
            int mid = (left + right) / 2;
            int length = 0;
            int maxLength = 0;
            for(int i=0; i<stones.length; i++){
                if(stones[i] - mid <= 0){
                    length++;
                    maxLength = Math.max(length, maxLength);
                }else{
                    length = 0;
                }
            }
            if (maxLength + 1 > k) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}