from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    #사각형을 0으로 테두리를 1로 채워서 테두리만 따라가면서 bfs 탐색
    land = [[-1] * 102 for i in range(102)]
    visited = [[0] * 102 for _ in range(102)] 
    
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, r)
        for i in range(x1, x2+1): #내부
            for j in range(y1, y2+1):
                if x1<i<x2 and y1<j<y2:
                    land[i][j] = 0
                    
        for i in range(x1, x2+1): #테두리
            for j in range(y1, y2+1):
                if land[i][j] != 0:
                    land[i][j] = 1
                    
                    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    
    queue = deque()
    queue.append([characterX*2, characterY*2])#캐릭터 위치
    visited[characterX*2][characterY*2] = 1
    
    while queue:
        x, y = queue.popleft()
        
        if x == itemX * 2 and y == itemY * 2:
            return visited[x][y] // 2
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if land[nx][ny] == 1 and visited[nx][ny] == 0: #인접한 좌표가 테두리고 방문하지 않았으면 
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))
                
    
                
   
    