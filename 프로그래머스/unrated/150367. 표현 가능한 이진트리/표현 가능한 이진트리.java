import java.util.*;
class Solution {
            static int result;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i=0; i<numbers.length; i++){
            String s = Long.toBinaryString(numbers[i]);
            int treeLen = 0;
            int height = 1;
            while(treeLen < s.length()){
                treeLen = (int)Math.pow(2, height++) - 1; // 2^트리높이 - 1 = 전체노드의 
            }
            
            boolean[] node = new boolean[treeLen];
            int idx = treeLen - s.length();
            for(int j=0; j<s.length(); j++){
                node[idx++] = s.charAt(j) == '1';
            }
            result = 1;
            isDummyRoot(node, 0, treeLen - 1, false);
            answer[i] = result;
            
        }
        return answer;
    }
    private static void isDummyRoot(boolean[] node, int start, int end, boolean prev){
        int mid = (start + end) / 2;
        boolean root = node[mid];
        if(root && prev){
            result = 0;
            return;
        }
        if(start != end){
            isDummyRoot(node, start, mid-1, !root); 
            isDummyRoot(node, mid+1, end, !root);
        }
    }
}