import java.util.*;
class Solution {
    
    private String rotate(String s, int i){
        StringBuilder sb = new StringBuilder(s.substring(i, s.length()));
        int idx = 0;
        while(idx < i){
            char c = s.charAt(idx);
            sb.append(c);
            idx++;
        }
        return sb.toString();
    }
    
    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
           switch (ch) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != ch) return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            String str = rotate(s, i);
            if(isValid(str)) answer++;
        }
        
        return answer;
    }
}