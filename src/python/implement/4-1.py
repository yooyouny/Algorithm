n = int(input())
data = []
data = input().split()
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
x, y = 1, 1
type = ['L', 'R', 'U', 'D']
for plan in data:
  for j in range(len(type)):
    if plan == type[j]:
     nx = x + dx[j]
     ny = y + dy[j]
     break
  if(nx<1 or nx>n or ny<1 or ny>n):
      continue
  x, y = nx, ny
print(x, y)

