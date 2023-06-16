import java.util.*;
class Solution {
    private static int getLeftPercent(int idx, int[] progresses, int[] speeds){
        int result = (100 - progresses[idx]) / speeds[idx];
        return (100 - progresses[idx]) % speeds[idx] == 0 ? result : result + 1;      
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            queue.add(i); //인덱스 저장
        }
        
        int cnt = 0;
        int day = 0;
        
        while(!queue.isEmpty()){
            int idx = queue.poll();
            int left = getLeftPercent(idx, progresses, speeds);
            
            if(left>day){
                if(day != 0){
                    answer.add(cnt);
                    cnt = 0;
                }
                day = left;  
            }
            cnt++;
        }
        answer.add(cnt);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}