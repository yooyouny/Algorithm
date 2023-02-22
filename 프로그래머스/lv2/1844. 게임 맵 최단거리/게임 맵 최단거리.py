from collections import deque

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

def bfs(x, y, maps, n, m):
    queue = deque()
    queue.append((0, 0))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx, ny))
            
def solution(maps):
    
    n = len(maps)
    m = len(maps[0])
    
    bfs(0, 0, maps, n, m)
    if maps[n-1][m-1] != 1:
        return maps[n-1][m-1]
    else :
        return -1