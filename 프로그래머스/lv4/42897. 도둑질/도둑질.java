import java.util.*;
class Solution {
    static int[] startDp;
    static int[] lastDp;
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        
        int[] startHouse = new int[len];
        for(int i=1; i<len; i++){
            startHouse[i] = money[i-1];
        }

        int[] lastHouse = new int[money.length];
        for(int i=1; i<money.length; i++){
            lastHouse[i] = money[i];
        }
        
        answer = Math.max(answer, stealHouse(startHouse));
        answer = Math.max(answer, stealHouse(lastHouse));
        
        return answer;
    }
    private static int stealHouse(int[] house){
        for(int i=2; i<house.length; i++){
            house[i] = Math.max(house[i-1], house[i-2] + house[i]);
        }
        return house[house.length-1];
    }
}