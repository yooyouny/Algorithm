import java.util.*;
class Solution {
    private boolean isContainsProduct(String[] gems, Set<String> products){
        Set<String> gemsSet = new HashSet<>(Arrays.asList(gems));
        return gemsSet.containsAll(products);
    }
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> products = new HashSet<>(Arrays.asList(gems));
        int length = gems.length + 1;
        
        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0;  // 윈도우의 시작 위치
        int windowLen = gems.length;  // 윈도우의 길이
        
        for (int i = 0; i < gems.length; i++) {
            gemCount.put(gems[i], gemCount.getOrDefault(gems[i], 0) + 1);
            
            while (gemCount.size() == products.size()) {
                if (windowLen > i - start) {
                    windowLen = i - start;
                    answer[0] = start + 1;
                    answer[1] = i + 1;
                }
                
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if (gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                
                start++;
            }
        }
        
        return answer;
    }
}