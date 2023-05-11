import java.util.*;
class Solution {
    List<int[]> list;
    public void hanoi(int n, int from, int to, int prev){
        if(n == 1){
            list.add(new int[]{from, to});
        }else{
            hanoi(n-1, from, prev, to);// 원반의 개수가 줄어들면서 from부터 prev까지
            list.add(new int[]{from, to});
            hanoi(n-1, prev, to, from);
        }
    }
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        return list.stream().toArray(int[][] :: new);
    }
}