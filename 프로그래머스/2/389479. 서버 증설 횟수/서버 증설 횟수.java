import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        Map<Integer, Integer> resetMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            if(resetMap.containsKey(i)){// 차감
                int cnt = resetMap.get(i);
                resetMap.remove(i);
                server -= cnt;
            }
            if(players[i] < m) continue;// m명 미만은 제외 
            int needServer = (int)Math.ceil(players[i] / m);
            if(needServer > server){
                int addServer = needServer - server;
                resetMap.put(i+k, addServer);
                server += addServer;
                answer += addServer;
            }
        }
        return answer;
    }
}