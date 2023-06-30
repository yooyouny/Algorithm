import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int sco : scoville){
            queue.add(sco);
        }
        while(queue.peek() < K && queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();
            int mix = first + (second * 2);
            queue.add(mix);
            answer++;
        }

        return K > queue.peek() ? -1 : answer;
    }
}