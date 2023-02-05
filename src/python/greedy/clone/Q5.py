from itertools import combinations

n, m = map(int, input().split())
data = map(int, input().split())

l = data
for i in range(1, n):
  l[i-1] = i
comb = list(combinations(l, 2))
print(comb)

