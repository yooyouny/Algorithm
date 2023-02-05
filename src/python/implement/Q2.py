init = input()
row = int(init[1])
column = int(ord(init[0])) - int(ord('a')) + 1 # 1.1 좌표에서 시작
steps = [(-2, -1), (-2, 1), (2, 1), (2, -1), (-1, 2), (1, 2), (1, -2), (-1, -2)]
count = 0
for step in steps:
  nr = row + step[0]
  nc = column + step[1]
  if(nr < 1 or nc < 1 or nr > 8 or nc > 8):
   continue
  count += 1
print(count)
