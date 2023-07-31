import java.util.*;
class Solution {
    class Word{
        String word;
        int cnt;
        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()){
            Word element = queue.poll();
            
            if(target.equals(element.word))
                return element.cnt;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && isConvertable(element.word, words[i])){
                    visited[i] = true;
                    queue.offer(new Word(words[i], element.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    private boolean isConvertable(String start, String end){
        int cnt = 0;
        char[] from = start.toCharArray();
        char[] to = end.toCharArray();
        for(int i=0; i<from.length; i++){
            if(from[i] != to[i]) cnt++;
        }
        return cnt == 1;
    }
}