import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            char bracket = s.charAt(i);
            if(bracket == '(')
                stack.push('(');
            else{
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}