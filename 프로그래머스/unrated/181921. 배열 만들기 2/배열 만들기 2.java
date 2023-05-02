import java.util.*;
class Solution {
    public boolean isZeroFiveNum(int n){
        int digit = 0;
        while(n > 0){
            digit = n % 10;
            if(digit != 0 && digit != 5)
                return false;
            n /= 10;
        }
        return true;
    }
    
    public int[] solution(int l, int r) {    
        List<Integer> result = new ArrayList<>();
        
        while(l<=r){
            if(isZeroFiveNum(l))
                result.add(l);
            l++;
        }
        if(result.size() == 0)
            return new int[]{-1};
        
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}