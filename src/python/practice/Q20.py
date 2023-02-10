from itertools import combinations

n = int(input())
school = []
spaces = []
teachers = []

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
  school.append(input().split())
  for j in range(n):
    if school[i][j] == 'T':
      teachers.append((i, j))
    if school[i][j] == 'X':
      spaces.append((i, j))

find = False
def watch(x, y, direction):
  if direction == 0:
    while y>=0:
      if school[x][y] == 'S':
        return True
      if school[x][y] == 'O':
        return False
      y-=1
  if direction == 1:
    while y < n:
      if school[x][y] == 'S':
        return True
      if school[x][y] == 'O':
        return False
      y+=1
  if direction == 2:
    while x>=0:
      if school[x][y] == 'S':
        return True
      if school[x][y] == 'O':
        return False
      x-=1
  if direction == 3:
    while x<n:
      if school[x][y] == 'S':
        return True
      if school[x][y] == 'O':
        return False
      x+=1
  return False
def process():
  for x, y in teachers:
    for i in range(4):
      if watch(x, y, i):
        return True
  return False

for data in combinations(spaces, 3):
  for x, y in data:
    school[x][y] = 'O'
  if not process():
      find = True
      break
  for x, y in data:
    school[x][y] = 'X'

if find:
  print('YES')
else:
  print('NO')
