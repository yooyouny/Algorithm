import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = Integer.MAX_VALUE;
        if(x == y) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new int[]{x, 0});
        
        while(!queue.isEmpty()){
            int[] pop = queue.poll();
            int num = pop[0];
            int cnt = pop[1];
            
            if(num > y) continue;
            
            if(num == y){
                return cnt;
            }
            
            if(!set.contains(num + n)){
                queue.add(new int[]{num + n, cnt+1});
                set.add(num + n);
            }
            if(!set.contains(num * 2)){
                queue.add(new int[]{num * 2, cnt+1});
                set.add(num * 2);
            }
            if(!set.contains(num * 3)){
                queue.add(new int[]{num * 3, cnt+1});
                set.add(num * 3);
            }
        }
        
        return -1;
    }
}