import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int todayInt = convertDay(today);
        
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]) * 28);
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] split = privacies[i].split(" ");
            int signDay = convertDay(split[0]);
            int termMonth = termMap.get(split[1]);
            if(signDay + termMonth <= todayInt)
                answer.add(i+1);
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    private int convertDay(String date){
        String[] split = date.split("\\.");
        int day = (28 * 12 * Integer.parseInt(split[0])) 
            + (28 * Integer.parseInt(split[1])) 
            + Integer.parseInt(split[2]);
        return day;
    }
}