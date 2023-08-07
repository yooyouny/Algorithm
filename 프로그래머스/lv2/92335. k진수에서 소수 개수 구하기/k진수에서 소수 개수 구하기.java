import java.util.*;

class Solution {
    
    public boolean isPrime(long n){
        if(n<=1) return false;
        for(int i=2; i<= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    
    public int solution(int n, int k) {
        
        String[] splitToZero = Long.toString(n, k).split("0");
        
        int count = 0;
        for (String s : splitToZero) {
            if(s.equals("")) continue;
            if(isPrime(Long.parseLong(s))) count++;
        }

        return count;
    }
}