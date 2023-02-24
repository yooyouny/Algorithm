n, m = map(int, input().split())
trees = list(map(int, input().split()))
start = 1
end = max(trees)
while start<=end: #같아지는 순간이 나무의 최대절단 높이
  mid = (start+end) // 2
  sum = 0
  for tree in trees:
    if tree >= mid:
      sum += tree - mid
  if sum >= m:
    start = mid + 1
  else:
    end = mid - 1
print(end)