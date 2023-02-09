from collections import deque
n, m = map(int, input().split())
graph = []

for i in range(n):
  graph.append(list(map(int, input())))

dy = [0, 0, -1, 1] #행
dx = [-1, 1, 0, 0] #열
def bfs(x, y):
  queue = deque()
  queue.append((x, y)) #처음 좌표는 큐에 넣음

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx<0 or ny<0 or nx>=n or ny>=m: #범위 밖이면 무시
        continue
      if(graph[nx][ny] == 0): #괴물 있거나 벽이면 갈 수 없으므로 무시
        continue
      if(graph[nx][ny] == 1):
        graph[nx][ny] = graph[x][y] + 1 #count 표시
        queue.append((nx, ny))

  return graph[n-1][m-1] # 탈출구에 쓰인 count

print(bfs(0, 0))

