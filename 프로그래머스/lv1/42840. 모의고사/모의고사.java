import java.util.*;
class Solution {
    public int getScore(int[] pattern, int[] answers){
        int idx = 0;
        int score = 0;
        for(int i=0; i<answers.length; i++){
            if(pattern.length <= idx) idx = 0;
            if(pattern[idx] == answers[i]) score++;
            idx++;
        }
        return score;
    }
    public int[] solution(int[] answers) {
        
        int[][] pattern = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] score = {0, 0, 0};
        
        score[0] = getScore(pattern[0], answers);
        score[1] = getScore(pattern[1], answers);
        score[2] = getScore(pattern[2], answers);
        
        int max = Arrays.stream(score).max().orElse(0);
        
        List<Integer> winners = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == score[i])
                winners.add(i+1);
        }
        
        return winners.stream().mapToInt(Integer::intValue).toArray();
    }
}