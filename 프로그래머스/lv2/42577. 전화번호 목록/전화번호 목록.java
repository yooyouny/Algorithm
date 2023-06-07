import java.util.*;
class Solution {
    //startsWith는 공백 무시하고 다 비교해줌 
    public boolean solution(String[] phone_book) {
        Set<String> prefix = new HashSet<>();
        for(String phoneNumber : phone_book){
            for(int i=1; i<phoneNumber.length(); i++){
                prefix.add(phoneNumber.substring(0, i));
            }
        }
        for(String phoneNumber : phone_book){
            if(prefix.contains(phoneNumber))
                return false;
        }
        return true;
    }
}