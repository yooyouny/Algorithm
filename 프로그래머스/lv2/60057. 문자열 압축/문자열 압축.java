class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String pattern = s.substring(0, i);
            int cnt = 1;
            
            for(int j=i; j<s.length(); j+=i){
                if(pattern.equals(s.substring(j, Math.min(j+i, s.length())))){
                    cnt++;
                }else{
                    if(cnt > 1) sb.append(cnt);
                    sb.append(pattern);
                    pattern = s.substring(j, Math.min(j+i, s.length()));
                    cnt = 1;
                }
            }
            if(cnt > 1) sb.append(cnt);
            sb.append(pattern);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
