from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b) # a과 연결된 노드의 b들을 모아놓음

queue = deque
count = 0
def bfs(x):
  queue.append(x)
  global count
  count += 1
  while queue:
    city = queue.popleft()
    for next_city in graph[city]:
      queue.append(next_city)
  return count
print(bfs(0))
