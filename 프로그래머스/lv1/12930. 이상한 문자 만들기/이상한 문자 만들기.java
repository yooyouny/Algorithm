class Solution {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                idx = 0;
                sb.append(" ");
                continue;
            }
            if(idx % 2 == 0){
                sb.append(Character.toString(ch).toUpperCase());
            }else{
                sb.append(Character.toString(ch).toLowerCase());
            }
            idx++;
        }
        return sb.toString();
    }
}