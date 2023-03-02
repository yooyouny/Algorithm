from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0
    
    queue = deque()
    queue.append((begin, 0))
    
    while queue:
        start_str, cnt = queue.popleft()
        if start_str == target:
            return cnt
        for word in words:
            diff_cnt = 0
            for idx in range(len(word)):
                if word[idx] != start_str[idx]:
                    diff_cnt += 1
            if diff_cnt == 1:
                queue.append((word, cnt + 1))

    