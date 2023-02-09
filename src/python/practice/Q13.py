from itertools import combinations
n, m = map(int, input().split())
home = []
chiken = []

for r in range(n):
  data = list(map(int, input().split()))
  for c in range(n):
    if data[c] == 1:
      home.append([r, c])
    if data[c] == 2:
      chiken.append([r, c])

candidates = list(combinations(chiken, m))
def calculate(candidate):
  result = 0
  for hx, hy in home:
    temp = 1e9
    for cx, cy in candidate:
      temp = min(temp, abs(hx - cx) + abs(hy - cy))
    result += temp
  return result

result = 1e9
for candidate in candidates:
  result = min(result, calculate(candidate))
print(result)

