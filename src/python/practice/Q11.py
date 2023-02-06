n = int(input())
k = int(input())
data = [[0] * (n+1) for _ in range(n+1)]
info = []

for _ in range(k):
  x, y = map(int, input().split())
  data[x][y] = 1


l = int(input())
for _ in range(l):
  x, c = input().split()
  info.append((int(x), c))

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def turn(direction, char):
  if char == 'L':
    direction = (direction - 1) % 4
  else:
    direction = (direction + 1) % 4
  return direction

def simulate():
  x, y = 1, 1
  data[x][y] = 2
  direction = 0
  time = 0
  index = 0
  q = [(x, y)]
  while True:
    nx = x + dx[direction]
    ny = y + dy[direction]
    if nx >= 1 and ny >= 1 and ny <= n and nx <= n and data[nx][ny] != 2:
      if data[nx][ny] == 0:
        data[nx][ny] = 2
        q.append((nx, ny))
        px, py = q.pop(0)
        data[px][py] = 0
      if data[nx][ny] == 1:
        data[nx][ny] = 2
        q.append((nx, ny))
    else:
      time += 1
      break
    x, y = nx, ny
    time += 1
    if index < l and time == info[index][0]:
      direction = turn(direction, info[index][1])
      index += 1
  return time

print(simulate())


