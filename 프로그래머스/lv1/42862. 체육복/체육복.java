import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int possible = 0;
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(reserve[j] == lost[i]){
                    lost[i] = reserve[j] = -1;// 여분가져온 체육복
                    possible++;
                    break;
                }
            }
        }
        
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])){
                    reserve[j] = -1;
                    possible++;
                    break;
                }
            }
        }
        
        return n - lost.length + possible;
    }
}