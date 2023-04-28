class Solution {
    public int[] solution(long n) {
        
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        String[] result = sb.reverse().toString().split("");
        int[] answer = new int[result.length];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = Integer.parseInt(result[i]);
        }
        
        return answer;
    }
}