n, m = map(int, input().split())
d = [[0] * m for _ in range(n)] #가본 곳을 1 안가본 곳을 0으로 저장하는 리스트
x, y, direction = map(int, input().split())

array = []
for i in range(n):
  array.append(list(map(int, input().split()))) #문제에서 요구하는 맵 형태 저장 리스트

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

count = 1
turn_time = 0

def turn_left():
  global direction
  direction -= 1
  if direction == -1:
    direction = 3

while True:
 turn_left()
 nx = dx[direction]
 ny = dy[direction]
 if d[nx][ny] == 0 and array[nx][ny] == 0:
   x = nx
   y = ny
   count += 1
   d[nx][ny] == 1
   turn_time = 0
   continue
 else:
   turn_time += 1
 if turn_time == 4:
   nx = x - dx[direction]
   ny = y - dy[direction]
   if array[nx][ny] == 0:
     x = nx
     y = ny
   else:
    break
   turn_time = 0

print(count)



