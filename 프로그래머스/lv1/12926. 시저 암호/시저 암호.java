class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] sToCharArr = s.toCharArray();
        for(int i=0; i<sToCharArr.length; i++){
            if (sToCharArr[i] == ' '){
                answer += " ";
                continue;
            }
            int next = sToCharArr[i] + n;
            if (Character.isLowerCase(sToCharArr[i]) && next > 122){
                next -= 26;
            } else if (Character.isUpperCase(sToCharArr[i]) && next > 90){
                next -= 26;
            } 
            answer += (char)next;
        }
        return answer;
    }
}