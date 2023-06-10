import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> number = new HashSet<>();
        for(int n : numbers){
            number.add(n);
        }
        for(int i=1; i<=9; i++){
            if(!number.contains(i)) 
                answer += i;
        }
        return answer;
    }
}