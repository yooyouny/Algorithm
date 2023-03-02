def solution(n, computers):
    answer = 0
    visited = [False] * n
 
    def dfs(next):
        visited[next] = True
        for i in range(n):
            if computers[next][i] == 1 and not visited[i]:
                dfs(i)
        
    for i in range(n):
        for j in range(n):
            if not visited[j] and computers[i][j] == 1:
                dfs(j)
                answer += 1
    return answer