from itertools import combinations

n, m = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(n)]


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = 0
def spread_virus(tmp, x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if(nx >= 0 and ny >= 0 and nx<n and ny<m and tmp[nx][ny] == 0):
      tmp[nx][ny] = 2
      spread_virus(tmp, nx, ny)
def cnt(tmp):
  cnt = 0
  for i in range(n):
    for j in range(m):
      if tmp[i][j] == 0:
        cnt+=1
  return cnt

def solution():
  result = 0
  tmp = [[0]*m for _ in range(n)]

  idx = []
  for i in range(n):
    for j in range(m):
      if lab[i][j] == 0:
        idx.append((i, j))
  for candinates in list(combinations(idx, 3)):
    for candinate in candinates:
      x, y = candinate
      lab[x][y] = 1 #벽 세우기

    for i in range(n):
      for j in range(m):
        tmp[i][j] = lab[i][j]

    for i in range(n):
      for j in range(m):
        if tmp[i][j] == 2:
          spread_virus(tmp, i, j)

    result = max(result, cnt(tmp))

    for candinate in candinates:
      x, y = candinate
      lab[x][y] = 0

  return result


print(solution())
