import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int gyul : tangerine){
           map.put(gyul, map.getOrDefault(gyul, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : map.values()){
            pq.add(cnt);
        } // 2 2 2 1 1 or 4 3 1
        
        int answer = 0;
        while(k > 0){
            if(pq.peek() > k){
                pq.poll();
                answer++;
                break;
            }else{
                k -= pq.poll();
                answer++;
            }
        }
        return answer;
    }
}