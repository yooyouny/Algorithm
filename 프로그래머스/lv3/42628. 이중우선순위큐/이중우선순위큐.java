import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> ascending = new PriorityQueue<>();// 오름차순 
        PriorityQueue<Integer> descending = new PriorityQueue<>((a, b) -> b - a);// 내림차순
        int size = 0; // 공통 key 
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0) == 'I'){// 큐에 삽입
                int num = Integer.parseInt(operations[i].split("I ")[1]);
                ascending.offer(num);
                descending.offer(num);
                size++;
            }else{
                if(!descending.isEmpty() && operations[i].equals("D 1")){// 최댓값 삭제
                    descending.poll();
                    size--;
                }
                else if(!ascending.isEmpty() && operations[i].equals("D -1")){
                    ascending.poll();
                    size--;

                }
                if(size == 0){
                    descending.clear();
                    ascending.clear();
                }
            }
        }
        if(descending.isEmpty() && ascending.isEmpty())
            return new int[]{0, 0};
        
        return new int[]{descending.peek(), ascending.peek()};
    }
}