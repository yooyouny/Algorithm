cnt = 0

def dfs(numbers, visited,index, target, sum):
    global cnt
    if index == len(numbers):
        if target == sum:
            cnt += 1
        return 
    
    visited[index] = 1

    sum += numbers[index]
    dfs (numbers, visited, index + 1, target, sum)
    sum -= numbers[index]
        
    sum -= numbers[index]
    dfs (numbers, visited, index + 1, target, sum)
    sum += numbers[index]
    
    visited[index] = 0
    
    return
        
    

def solution(numbers, target):
    visited = [0] * len(numbers)
    dfs(numbers, visited, 0, target,  0)
    return cnt
