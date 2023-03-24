from collections import deque
def solution(s):
    queue = deque()
    for ch in s:
        if ch == '(':
            queue.append('(')
        else:
            if len(queue) > 0:
                queue.popleft()
            else:
                return False
    if len(queue) > 0:
        return False
    return True