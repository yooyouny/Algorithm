
n = int(input())
hunter = list(map(int, input().split()))
hunter.sort()
group = 0
count = 0

for i in hunter:
  count += 1
  if count >= i:
    group += 1
  else:
    count = 0

print(group)






