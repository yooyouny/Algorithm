n = int(input())
time = list(map(int, input().split()))
time.sort()

result = 0
sum = 0
for i in time:
  sum += i
  result += sum

print(result)