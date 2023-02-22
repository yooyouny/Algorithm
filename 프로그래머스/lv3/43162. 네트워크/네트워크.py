
def dfs(x, computers, visited, n):
    visited[x] = True
    
    if x == n:
        return
    
    for j in range(n):
        if computers[x][j] == 1 and not visited[j]:
            dfs(j, computers, visited, n)
            
        
def solution(n, computers):
    visited = [False] * (n+1)
    answer = 0
    
    for computer in range(n):
        if not visited[computer]:
            dfs(computer, computers, visited, n)
            answer += 1
    
    return answer