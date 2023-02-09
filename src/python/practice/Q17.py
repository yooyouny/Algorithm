from collections import deque

n, k = map(int, input().split())
lab = []
data = []

for i in range(n):
  lab.append(list(map(int, input().split())))
  for j in range(n):
    if(lab[i][j] != 0):
      data.append((lab[i][j], 0, i, j))

data.sort()
q = deque(data)

target, a, b = map(int, input().split())
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
num = 1
while q:
  virus, s, x, y = q.popleft()
  if s == target:
    break
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if(0<=nx and 0<=ny and nx<n and ny<n):
      if lab[nx][ny] == 0:
        lab[nx][ny] = virus
        q.append((virus, s+1, nx, ny))

print(lab[a - 1][b - 1])

