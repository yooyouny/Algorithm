class Solution {
    public int[] solution(long n) {
        
        String reverse = String.valueOf(n);
        int[] answer = new int[reverse.length()];
        int answerIdx = 0;
        
        for(int i=reverse.length()-1; i>=0; i--){
            answer[answerIdx++] = reverse.charAt(i) - '0';
        }
        
        return answer;
    }
}