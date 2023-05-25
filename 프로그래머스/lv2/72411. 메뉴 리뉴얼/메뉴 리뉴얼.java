import java.util.*;

class Solution {
    static HashMap<String, Integer> menus;
    
    static void combination(String order, HashSet<Character> set, int r, int start){
        if(r == 0){
            List<Character> selected = new ArrayList<>(set);
            Collections.sort(selected);
            StringBuilder sb = new StringBuilder();
            for (char c : selected) {
                sb.append(c);
            }
            String str = sb.toString();
            
            if(menus.containsKey(str)){
                menus.put(str, menus.get(str) + 1);
            } else{
                menus.put(str, 1);
            }
            return;
        }

        for(int i = start; i < order.length(); i++){
            set.add(order.charAt(i));
            combination(order, set, r - 1, i + 1);
            set.remove(order.charAt(i));
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        menus = new HashMap<>();

        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int i = 0; i < course.length; i++){
            for(int j = 0; j < orders.length; j++){
                HashSet<Character> set = new HashSet<>();
                combination(orders[j], set, course[i], 0);
            }
            
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(menus.entrySet());
            entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            int max = 0;
            for(Map.Entry<String, Integer> entry : entries) {
                if(entry.getValue() > 1 && entry.getValue() >= max) {
                    max = entry.getValue();
                    list.add(entry.getKey());
                }
            }
    
            menus.clear();
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        list.toArray(answer);
    
        return answer;
    }
}
