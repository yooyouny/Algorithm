import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] info = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int[][] mineralFatigue = new int[minerals.length / 5 + 1][3];
        int pickCnt = Arrays.stream(picks).sum();
        int answer = 0;
        
        for(int i=0; i<minerals.length; i+=5){
            if(pickCnt == 0) break; // 곡괭이가 없는 경우
            int[] fatigue = new int[3];
            
            for(int j=i; j<i+5 && j<minerals.length; j++){
                char mineralChar = minerals[j].charAt(0);
                int mineralIdx = mineralChar == 'i' ? 1 :
                                mineralChar == 's' ? 2 : 0;
                
                fatigue[0] += info[0][mineralIdx];
                fatigue[1] += info[1][mineralIdx];
                fatigue[2] += info[2][mineralIdx];
            }
            mineralFatigue[i/5] = fatigue;
            pickCnt--;
        }
        
        Arrays.sort(mineralFatigue, (a, b) -> Integer.compare(b[2], a[2]));
        
        
        for(int i=0; i<mineralFatigue.length; i++){
            if(picks[0] > 0) {
                answer += mineralFatigue[i][0];
                picks[0]--;
            }else if(picks[1] > 0) {
                answer += mineralFatigue[i][1];
                picks[1]--;
            }else if(picks[2] > 0) {
                answer += mineralFatigue[i][2];
                picks[2]--;
            }
        }
        return answer;
    }
}