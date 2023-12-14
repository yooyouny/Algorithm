import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
        for(int i=0; i<str1.length() - 1; i++){
            String str = str1.substring(i, i + 2);
            if(str.matches("^[a-zA-Z]*$"))
                str1List.add(str.toUpperCase());
        }
        for(int i=0; i<str2.length() - 1; i++){
            String str = str2.substring(i, i + 2);
            if(str.matches("^[a-zA-Z]*$"))
                str2List.add(str.toUpperCase());
        }
        int intersection = 0;
        int union = 0;
        
        for(String str : str1List){
            if(str2List.contains(str)){
                str2List.remove(str);
                intersection++;
            }
            union++;
        }

        for(String str : str2List){
            union++;
        }
                
        if(union == 0) return 65536;
    
        return (int)((double)intersection / union * 65536);
    }
}