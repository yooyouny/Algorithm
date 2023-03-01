'''
같은 집합에 있는 노드들로 여행을 간다면 YES
같은 집합이 아닌 노드로 여행을 간다면 NO
-> 양방향 그래프 탐색은 dfs보단 union-find 생각
'''
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())
M = int(input())
route = [[0] * N for _ in range(N)]
parent = [0] + list(range(1, N+1))

for i in range(N):
  route[i] = list(map(int, input().split()))

def union(a, b):
  a = find(a) #부모로 비교
  b = find(b)
  if a<b:
    parent[b] = a
  else:
    parent[a] = b
def find(city):
  if city == parent[city]: #바로 부모노드를 찾았을 경우
    return city
  parent[city] = find(parent[city]) #경로를 압축
  return parent[city]

for i in range(N):
  for j in range(N):
    if route[i][j] == 1:
      union(i+1, j+1)

plan = list(map(int, input().split()))
first_city = plan[0]
for i in range(1, M):
  if find(first_city) == find(plan[i]):
      continue
  else:
    print('NO')
    exit()
print('YES')