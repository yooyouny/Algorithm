import java.util.*;
class Solution {
    static int answer;
    public int solution(String begin, String target, String[] words) {
        if(Arrays.stream(words).noneMatch(word -> word.equals(target))) return 0;
        
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        
        return answer;
    }
    private void dfs(String begin, String target, String[] words, boolean[] visited, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            if(!isConvertable(begin, words[i])) continue;
            
            visited[i] = true;
            dfs(words[i], target, words, visited, cnt + 1);
            visited[i] = false;
        }
    }
    private boolean isConvertable(String from, String to){
        int cnt = 0;
        char[] fromArr = from.toCharArray();
        char[] toArr = to.toCharArray();
        for(int i=0; i<fromArr.length; i++){
            if(fromArr[i] != toArr[i]) cnt++;
        }
        return cnt == 1;
    }
}