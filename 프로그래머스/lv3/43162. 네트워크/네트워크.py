def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    def dfs(i):
        visited[i] = True
        for j in range(n):
            if i != j and not visited[j] and computers[i][j] == 1:
                dfs(j)
            
            
    for i in range(n):
        for j in range(n):
            if not visited[i] and computers[i][j] == 1:
                answer +=1 
                dfs(i)
                
    return answer