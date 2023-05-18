import java.util.*;

class Solution {
    Set<Set<String>> ids;
    
    public void dfs(HashSet<String> users, String[][] banIds, int idx, int depth){
        if(depth == banIds.length){
            ids.add(new HashSet<>(users));
            return;
        }
        for(String id : banIds[idx]){
            if(users.contains(id)) continue;
            users.add(id);
            dfs(users, banIds, idx + 1, depth + 1);
            users.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        ids = new HashSet<>();
        
        String[][] banIds = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                 .filter(id -> id.matches(banned))
                 .toArray(String[]::new))
                .toArray(String[][]::new);
        
        dfs(new HashSet<>(), banIds, 0, 0);

        return ids.size();
    }
}