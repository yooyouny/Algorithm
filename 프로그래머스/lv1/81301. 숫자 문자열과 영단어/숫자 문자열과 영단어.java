class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] alpha = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int len = 0;
        while(true){
            if(s.length() == 0) break;
            char character = s.charAt(0);
            if(character >= 'a'){
                for(int j=0; j<alpha.length; j++){
                    if(s.startsWith(alpha[j])){
                        sb.append(j);
                        s = s.substring(alpha[j].length());
                    }
                }
            }else{
                sb.append(character);
                s = s.substring(1);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}