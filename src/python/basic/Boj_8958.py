n = int(input())
for _ in range(n):
  s = str(input())
  score = 0
  result = 0
  val = True
  for ch in s:
    if ch == 'O':
      score += 1
      result += score
    else:
      score = 0
  print(result)
