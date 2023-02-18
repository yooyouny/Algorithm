from collections import deque
m, n = map(int, input().split())
box = [[0] * m for _ in range(n)]
for i in range(n):
  box[i] = list(map(int, input().split()))

queue = deque()
answer = 0

for i in range(n):
  for j in range(m):
    if box[i][j] == 1:
      queue.append((i, j))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
def bfs():
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0<=nx<n and 0<=ny<m and box[nx][ny] == 0:
        box[nx][ny] = box[x][y] + 1
        queue.append((nx, ny))

bfs()

for i in box:
  for j in i:
    if j == 0:
      print(-1)
      exit()
  answer = max(answer, max(i))
print(answer-1)
