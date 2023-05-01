class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();//1단계
        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");//2단계
        
        //3단계
        StringBuilder sb = new StringBuilder();
        boolean isPrevDot = false;
        for(int i=0; i<new_id.length(); i++){
            char c = new_id.charAt(i);
            if(c == '.'){
                if(!isPrevDot)
                    sb.append(c);
                isPrevDot = true;
            }else{
                sb.append(c);
                isPrevDot = false;
            }
        }
        new_id = sb.toString();
        
        if(new_id.startsWith("."))//4단계
           new_id = new_id.substring(1);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0, new_id.length()-1);
        
        if(new_id.length() == 0)//5단계
            new_id += "a";
        
        if(new_id.length() >= 16){//6단계
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith("."))
                new_id = new_id.substring(0, new_id.length()-1);
        }
        if(new_id.length() <= 2){//7단계
            char lastChar = new_id.charAt(new_id.length()-1);
            while(new_id.length() < 3){
                new_id += lastChar;
            }
        }
        return new_id;
    }
}