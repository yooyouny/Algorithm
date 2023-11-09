import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();// 종류, 개수를 저장하는 Map
        for(int type : topping){
            cntMap.put(type, cntMap.getOrDefault(type, 0) + 1);
        }
        
        Set<Integer> toppingSet = new HashSet<>();
        for(int type : topping){
            toppingSet.add(type);// 철수가 가져가는거 
            cntMap.put(type, cntMap.get(type) - 1);// 전체에서 철수가 가져간 종류를 뺌 = 최종적으로 남아있는 map의 종류는 동생이 가지는거 
            if(cntMap.get(type) == 0) 
                cntMap.remove(type);
            if(cntMap.size() == toppingSet.size()){// 종류의 개수가 딱 떨어지면 자르는 방법 수 증가
                answer++;
            }
        }
        return answer;
    }
}