def solution(n):
    answer = 0
    for i in range(1, n+1):
        answer += func(i, 0, n)

    return answer

def func(i, total, n):
    if total == n:
        return True
    elif total > n:
        return False
    else:
        return func(i+1, total+i, n)