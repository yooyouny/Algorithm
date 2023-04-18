class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(true){
            int oneCnt = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    answer[1]++;
                }else{
                    oneCnt++;
                }
            }
            
            s = Integer.toBinaryString(oneCnt);
            answer[0]++;
            if(s.equals("1"))
                break;
        }
        return answer;
    }
}