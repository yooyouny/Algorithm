from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0

    queue = deque()
    queue.append((begin, 0))
    
    while queue:
        request, cnt = queue.popleft()
        if request == target:
            return cnt
        
        for word in words:
            #사전에 있는 단어가 변환 가능한지 
            chk = 0
            for j in range(len(word)):
                if request[j] != word[j]: 
                    chk += 1
                    
            if chk == 1: # 단어변환이 가능함 
                queue.append((word, cnt + 1))
            
    return cnt