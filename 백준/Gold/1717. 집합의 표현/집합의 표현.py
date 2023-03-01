import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
tree = [0] + list(range(1, n+1))

def union(a, b): #부모로 비교 
  a = find(a)
  b = find(b)
  if a<b:
    tree[b] = a
  else:
    tree[a] = b

def find(node):
  if node == tree[node]: #바로 부모노드를 찾았을 경우
    return node
  tree[node] = find(tree[node]) #경로를 압축 
  return tree[node]

for i in range(m):
  q, a, b = map(int, input().split())
  if q == 0:
    union(a, b) #같은 부모 노드로 바꾸기

  elif q == 1:
    # if tree[b] == a:  연결된 경우를 찾지 못함, 탐색 해야함
    if find(a) == find(b): #부모가 같으면 같은 사이클
      print('YES')
    else:
      print('NO')