import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
def find(a):
  if a == parent[a]:
    return a
  parent[a] = find(parent[a])
  return parent[a]

def union(a, b):
  a = find(a)
  b = find(b)
  if a == b: #부모가 같으면
    return
  else: #부모가 다르면 부모노드를 하나로 바꿔줘야함
    parent[a] = b
    number[b] += number[a]
    #그룹 안에 몇명이 있는지 세는거

for i in range(int(input())):
  n = int(input())
  #문자열 key로 넣을때는 딕셔너리 활용
  parent = dict()
  number = dict()

  for _ in range(n):
    a, b = map(str, input().split())
    if a not in parent:
      parent[a] = a #부모를 자기 자신으로 세팅
      number[a] = 1
    if b not in parent:
      parent[b] = b
      number[b] = 1
    union(a, b)
    print(number[find(a)])