n = int(input())
data = list(map(int, input().split()))
plus, minus, multi, div = map(int, input().split())

min_value = 1e9
max_value = -1e9

def dfs(i, num):
  global min_value, max_value, plus, minus, multi, div
  if i == n:
    min_value = min(min_value, num)
    max_value = max(max_value, num)
  else:
    if plus>0:
      plus -= 1
      dfs(i+1, num + data[i])
      plus += 1
    if minus>0:
      minus -= 1
      dfs(i+1, num - data[i])
      minus += 1
    if multi>0:
      multi -= 1
      dfs(i+1, num * data[i])
      multi += 1
    if div>0:
      div -= 1
      dfs(i+1, num // data[i])
      div += 1

dfs(1, data[0])
print(max_value)
print(min_value)

