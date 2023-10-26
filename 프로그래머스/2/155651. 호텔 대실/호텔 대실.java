import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        if(book_time.length == 1) return 1;
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();// 끝나는 시간이 가장 빠른 순서대로 
        int[][] bookArr = new int[book_time.length][2];
        int bookArrIdx = 0;
        for(String[] time : book_time){
            int startTime = parseMinute(time[0]);
            int endTime = parseMinute(time[1]);
            bookArr[bookArrIdx++] = new int[]{startTime, endTime+10};
        }
        
        Arrays.sort(bookArr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        for(int i=0; i<bookArrIdx; i++){
            int[] time = bookArr[i];
            int startTime = time[0];
            int endTime = time[1];
            // 17:10 18:30 19:30
            if(queue.isEmpty()){
                queue.add(endTime);
            }else{
                int peekEndTime = queue.peek();
                if(peekEndTime > startTime){// 들어온 예약시간보다 늦게 끝날 경우
                    queue.add(endTime);
                }else{
                    queue.poll();
                    queue.add(endTime);
                }
            }
        }
        
        return queue.size();
    }
    private int parseMinute(String time){
        String[] parse = time.split(":");
        return Integer.parseInt(parse[0]) * 60 + Integer.parseInt(parse[1]);  
    }
}