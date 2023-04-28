import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> top = new PriorityQueue<>();
        for(int i=0; i<score.length; i++){
            top.add(score[i]);
            if(top.size() > k){
                top.poll();
            }
            answer[i] = top.peek();
        }
        return answer;
    }
}