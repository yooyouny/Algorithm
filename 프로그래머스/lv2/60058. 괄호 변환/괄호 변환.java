class Solution {
    public String solution(String p) {
        String answer = "";
        if(isCorrectString(p))
            return p;
        else
            answer = toBalnacedString(p);
        return answer;
    }
    private boolean isCorrectString(String s){
        if(s.charAt(0) == ')') return false;
        
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '(') 
                cnt++;
            else
                cnt--;
            if(cnt < 0) return false;
        }
        return true;
    }
    private String toBalnacedString(String w){
        
        if(w.length() == 0) return "";
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        int cnt = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) == '('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt == 0){
                u.append(w.substring(0, i+1));
                v.append(w.substring(i+1, w.length()));
                if(isCorrectString(u.toString())){
                    u.append(toBalnacedString(v.toString()));
                    break;
                }else{
                    String newStr = "";
                    newStr += "(";
                    newStr += toBalnacedString(v.toString());
                    newStr += ")";
                    newStr += attachString(u.toString());
                    return newStr;
                }
            }
        }
        return u.toString();
    }
    private String attachString(String s){
        StringBuilder sb = new StringBuilder();
        s = s.substring(1, s.length()-1);
        for(char c : s.toCharArray()){
            if(c == '(')
                sb.append(')');
            else
                sb.append('(');
        }
        return sb.toString();
    }
}