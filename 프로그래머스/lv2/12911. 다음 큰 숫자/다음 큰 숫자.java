import java.util.*;
class Solution {
    private static int getOneCnt(int n){
        int cnt = 0;
        String s = Integer.toBinaryString(n);
        for(char c : s.toCharArray()){
            if(c == '1')
                cnt++;
        }
        return cnt;
    }
    public int solution(int n) {
        int answer = 0;
        int inputCnt = getOneCnt(n);
        for(int num = n + 1; num < 1000000; num++){
            if(inputCnt == getOneCnt(num))
                return num;
        }
        return 0;
    }
}