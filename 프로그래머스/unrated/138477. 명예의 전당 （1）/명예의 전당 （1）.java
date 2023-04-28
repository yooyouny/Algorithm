import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int answerIdx = 0;
        List<Integer> top = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            if(top.size() < k){
                top.add(score[i]);
            }else{
                int min = top.get(0);
                if(score[i] > min){
                    top.remove(0);
                    top.add(score[i]);
                }
            }
            Collections.sort(top);
            answer[answerIdx++] = top.get(0);
        }
        return answer;
    }
}