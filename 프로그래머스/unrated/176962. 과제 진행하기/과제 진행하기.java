import java.util.*;
class Solution {
    class Study{
        String name;
        int start;
        int playTime;
        public Study(String name, String start, String playTime){
            this.name = name;
            this.start = getMinute(start);
            this.playTime = Integer.parseInt(playTime);
        }
        public int getMinute(String time){
            String[] parse = time.split(":");
            return (Integer.parseInt(parse[0]) * 60) + Integer.parseInt(parse[1]);
        }
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Queue<Study> plan = new PriorityQueue<>((s1, s2) -> s1.start - s2.start);
        Stack<Study> waiting = new Stack<>();
        
        
        for(String[] p : plans){
            plan.offer(new Study(p[0], p[1], p[2]));
        }
    
        int nowTime = 0;
        int idx = 0;
        
        while(!plan.isEmpty() || !waiting.isEmpty()){
            if(plan.isEmpty()){
                answer[idx++] = waiting.pop().name;
            }else if(waiting.isEmpty()){
                nowTime = plan.peek().start;
                waiting.push(plan.poll());
            }else{
                if(plan.peek().start < nowTime + waiting.peek().playTime){
                    waiting.peek().playTime -= plan.peek().start - nowTime;
                    nowTime = plan.peek().start;
                    waiting.push(plan.poll());
                }else{
                    nowTime += waiting.peek().playTime;
                    answer[idx++] = waiting.pop().name;
                }
            }
        }
        return answer;
    }
}