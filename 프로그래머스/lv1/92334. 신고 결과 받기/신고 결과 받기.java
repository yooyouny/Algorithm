import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> num = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            num.put(id_list[i], new HashSet<>());
        }
        
        Map<String, Integer> declare = new HashMap<>();
        for(String r : report){
            String[] token = r.split(" ");
            String reporter = token[0];
            String target = token[1];
            
            Set<String> set = num.get(reporter);
            if(set.contains(target))
                continue;
            
            set.add(token[1]);
            declare.putIfAbsent(target, 0);
            declare.put(target, declare.get(target) + 1);
        }
        
        Set<String> banned = declare.keySet().stream()
                            .filter(id -> declare.get(id) >= k)
                            .collect(Collectors.toSet());
        
        return Arrays.stream(id_list)
                    .mapToInt(id -> (int) num.get(id).stream()
                                            .filter(banned::contains)
                                            .count())
                    .toArray();
    }
}