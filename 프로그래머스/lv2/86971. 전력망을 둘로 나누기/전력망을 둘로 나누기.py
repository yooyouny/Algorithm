from collections import deque
def solution(n, wires):
    answer = n
    nodes = [[] for _ in range(n+1)]
    for a, b in wires:
        nodes[a].append(b)
        nodes[b].append(a)
        
    def bfs(start):
        queue = deque()
        queue.append(start)
        visited = [0] * (n+1)
        visited[start] = 1
        cnt = 1
        while queue:
            node = queue.popleft()
            for next in nodes[node]:
                if not visited[next]:
                    queue.append(next)
                    visited[next] = True
                    cnt += 1
        return cnt
                    
    for a, b in wires:
        nodes[a].remove(b)
        nodes[b].remove(a)
        
        answer = min(answer, abs(bfs(a) - bfs(b)))
        
        nodes[a].append(b)
        nodes[b].append(a)
        
    return answer