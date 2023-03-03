paper = [[0] * 101 for _ in range(101)]

for i in range(int(input())):
  x, y = map(int, input().split())
  for i in range(x, x+10):
    for j in range(y, y+10):
      paper[i][j] = 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

border = 0

for i in range(101):
  for j in range(101):
    if paper[i][j] == 1:
      for k in range(4):
        ni = i + dx[k]
        nj = j + dy[k]
        #4방향 탐색에서 0(색종이 밖)이 하나라도 발견될 경우 걔는 테두리임
        if paper[ni][nj] == 0:
          border += 1

print(border)