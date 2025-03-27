import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();// 수 : 건수
        
        String[] splits = s.split(",");
        for(String str : splits){
            String numberStr = str.replaceAll("[^0-9]", "");
            int num = Integer.parseInt(numberStr);
            if(cnt.containsKey(num))
                cnt.put(num, cnt.get(num) + 1);
            else
                cnt.put(num, 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(cnt.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<Integer, Integer> entry : entryList) {
             answer.add(entry.getKey());
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}