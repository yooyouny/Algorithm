import java.util.*;
class Solution {
      public long solution(int[] weights) {
  	    long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
          for(int w : weights) {
    		double weight = w * 1.0;
    		double m2 = (w*2.0) / 3.0;
    		double m3 = (w*1.0) / 2.0;
    		double m4 = (w*3.0) / 4.0;
            
    		if(map.containsKey(weight)) 
                answer += map.get(weight);
    		if(map.containsKey(m2)) 
                answer += map.get(m2);
    		if(map.containsKey(m3)) 
                answer += map.get(m3);
    		if(map.containsKey(m4)) 
                answer += map.get(m4);
    		
            map.put((w*1.0), map.getOrDefault((w*1.0), 0) + 1);
        }
        
        return answer;
    }
}