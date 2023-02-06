n, m, k = map(int, input().split())
list = list(map(int, input().split()))
list.sort()
first = list[-1]
second = list[-2]
result = 0

while True:
  for i in range(k):
    if(m == 0): break
    result += first
    m -= 1
  if m == 0:
    break
  result += second
  m -= 1

print(result)
