import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        
        for(int i=1; i<=8; i++){
            Set<Integer> current = new HashSet<>();
            //숫자연결 
            String num = String.valueOf(N).repeat(i);
            current.add(Integer.parseInt(num));
            
            //n번 사용한 경우는 n-1번 사용한 결과와 n-2번 사용한 결과를 조합 
            for(int j=1; j<i; j++){
                Set<Integer> next = dp.get(j);
                Set<Integer> first = dp.get(i-j);
                
                for(int num1 : next){
                    for(int num2 : first){
                        current.add(num1 + num2);
                        current.add(num1 - num2);
                        current.add(num1 * num2);
                        if(num2 != 0)
                            current.add(num1 / num2);
                    }
                }
            }
            if(current.contains(number)){
                return i;
            }
            dp.put(i, current);
            
        }
        return -1; // 8번이 넘어가면 -1 리턴 
    }
}