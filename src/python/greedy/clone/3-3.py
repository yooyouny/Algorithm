n, m = map(int, input().split())
result = 0
for _ in range(n):
  data = list(map(int, input().split()))
  value = min(data)
  result = max(value, result)
print(result)
