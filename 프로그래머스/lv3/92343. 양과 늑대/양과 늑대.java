import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int numNodes = info.length;
        boolean[][] tree = new boolean[numNodes][numNodes];
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[parent][child] = true;
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0); // Start from the root
        
        return getMaxSheepCnt(visited, tree, info, 0, 0);
    }
    
    private int getMaxSheepCnt(Set<Integer> visited, boolean[][] tree, int[] info, int sheep, int wolf) {
        int answer = sheep;
        
        for (int node : visited) {
            int totalSheep = sheep + (info[node] == 0 ? 1 : 0);
            int totalWolf = wolf + (info[node] == 1 ? 1 : 0);
            
            if (totalWolf >= totalSheep) {
                continue;
            }
            
            Set<Integer> nextVisited = new HashSet<>(visited);
            nextVisited.remove(node);
            
            for (int next = 0; next < tree.length; next++) {
                if (tree[node][next]) {
                    nextVisited.add(next);
                }
            }
            
            answer = Math.max(getMaxSheepCnt(nextVisited, tree, info, totalSheep, totalWolf), answer);
        }
        
        return answer;
    }
}