import sys; input = sys.stdin.readline
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, cnt, sum):
  global answer
  if cnt == 4:
    answer = max(answer, sum)
    return
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<N and 0<=ny<M and not visited[nx][ny]:
      if cnt == 2:
        visited[nx][ny] = True
        dfs(x, y, cnt+1, sum+paper[nx][ny])
        visited[nx][ny] = False

      visited[nx][ny] = True
      dfs(nx, ny, cnt+1, sum+paper[nx][ny])
      visited[nx][ny] = False

N, M = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
answer = 0

for i in range(N):
  for j in range(M):
    visited[i][j] = True
    dfs(i, j, 1, paper[i][j]) #이미 해당 블럭을 선택함
    visited[i][j] = False
print(answer)