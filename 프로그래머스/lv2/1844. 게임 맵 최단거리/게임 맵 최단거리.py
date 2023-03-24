from collections import deque
        
def solution(maps):
    dx = [0, 0, 1, -1]
    dy = [-1, 1, 0, 0]
    n = len(maps)
    m = len(maps[0])
    def bfs(x, y):
        queue = deque()
        queue.append((x, y))
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0<=nx<n and 0<=ny<m and maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    queue.append((nx, ny))
        
    bfs(0, 0)
    if maps[n-1][m-1] > 1:
        return maps[n-1][m-1] 
    else:
        return -1