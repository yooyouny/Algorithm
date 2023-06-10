import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> passer = new HashMap<>();
        for(String people : participant) passer.put(people, passer.getOrDefault(people, 0) + 1);
        for(String people : completion) passer.put(people, passer.getOrDefault(people, 0) - 1);
        
        for(String key : passer.keySet()){
            if(passer.get(key) != 0)
                answer = key;
        }
        
        return answer;
    }
}