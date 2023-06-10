import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_string.length(); i++){
            char ch = my_string.charAt(i);
            if(sb.indexOf(String.valueOf(ch)) == -1)
                sb.append(ch);
        }
        return sb.toString();
    }
}