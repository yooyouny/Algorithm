import java.util.*;
class Solution {
    private static boolean isWant(String product, String[] want, int[] initNumber){
        for(int i=0; i<want.length; i++){
            if(want[i].equals(product) && initNumber[i] > 0){
                initNumber[i]--;
                return true;
            }
        }
        return false;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i=0; i<discount.length; i++){
            int day = 0;
            int[] initNumber = Arrays.copyOf(number, number.length);
            
            for(int j=i; j<=Math.min(i+9, discount.length-1); j++){
                if(isWant(discount[j], want, initNumber)){
                    day++;
                }
            }
            if(day == 10 && Arrays.stream(initNumber).sum() == 0) {
                answer++;
            }

        }
        return answer;
    }
}