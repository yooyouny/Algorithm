class Solution {
    int answer, cnt;
    public void findWordIndex(StringBuilder sb, String word){
        if(sb.toString().equals(word)){
            answer = cnt;
            return;
        }
        if(sb.length() == 5) return;

            
        char[] words = {'A', 'E', 'I', 'O', 'U'};
      
        for(int i=0; i<5; i++){ // words idx
            sb.append(words[i]);
            cnt++;
            findWordIndex(sb, word);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    public int solution(String word) {
        findWordIndex(new StringBuilder(), word);
        return answer;
    }
}