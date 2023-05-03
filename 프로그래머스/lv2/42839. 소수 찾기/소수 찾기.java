import java.util.*;
class Solution {
    Set<Integer> set;
    public void comb(char[] numbers, boolean[] visited, StringBuilder sb){
        if(sb.length() > 0){
            set.add(Integer.parseInt(sb.toString()));
        }
            
        for(int i=0; i<numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(numbers[i]);
                comb(numbers, visited, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }   
        }
    }
    public boolean isPrime(int n){
        if(n < 2) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public int solution(String numbers) {

        int cnt = 0;
        set= new HashSet<>();
        comb(numbers.toCharArray(), new boolean[numbers.length()], new StringBuilder());
        for(int n : set){
            if(isPrime(n))
                cnt++;
        }
        return cnt;
    }
}