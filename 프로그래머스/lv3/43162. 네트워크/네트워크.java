import java.util.*;
class Solution {
    private int find(int n, int[] parent){
        if(parent[n] == n){
            return n;
        }
        return find(parent[n], parent);
    }
    private void union(int a, int b, int[] parent){
        a = find(a, parent);
        b = find(b, parent);
        if( a == b ) return;
        parent[a] = b;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j] == 1)
                    union(i, j, parent);
            }
        }
        
        for(int i=0; i<n; i++){
            if(i == parent[i]) answer++;
        }
        
        return answer;
    }
}