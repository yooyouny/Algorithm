n, m = map(int, input().split())
board = [[] * m for _ in range(n)]
check = [[0] * m for _ in range(n)]
result = []

for i in range(n):
  board[i] = list(input())

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def painting(x, y):
  for k in range(1, m):
    flag = True
    for i in range(4):
      nx = x + dx[i] * k
      ny = y + dy[i] * k
      if 0<=nx<n and 0<=ny<m and board[nx][ny] == '*':
        pass
      else:
        flag = False
        break
    if flag:
      result.append((x+1, y+1, k))
      for i in range(4):
        nx = x + dx[i] * k
        ny = y + dy[i] * k
        check[nx][ny] = 0
      check[x][y] = 0
    else:
      break


for i in range(n):
  for j in range(m):
    if board[i][j] == '*':
      check[i][j] = 1

for i in range(n):
  for j in range(m):
    if board[i][j] == '*': #십자가의 중심으로 생각
      painting(i, j)

total = 0
for i in range(n):
  for j in range(m):
    total += check[i][j]

if total == 0:
  print(len(result))
  for i in range(len(result)):
    print(result[i][0], result[i][1], result[i][2])
else:
  print(-1)