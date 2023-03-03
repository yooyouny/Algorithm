from bisect import bisect_left, bisect_right
N = int(input())
cards = list(map(int, input().split()))
M = int(input())
target = list(map(int, input().split()))

cnt = []
cards.sort()


for i in range(len(target)):
 right = bisect_right(cards, target[i])
 left = bisect_left(cards, target[i])
 cnt.append(right-left)

for i in range(len(cnt)):
  print(cnt[i], end = ' ')