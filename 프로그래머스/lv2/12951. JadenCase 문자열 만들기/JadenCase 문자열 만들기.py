def solution(s):
    answer = []
    arr = list(map(str, s.split(' ')))
    for word in arr:
        answer.append(word.capitalize())
    return ' '.join(answer)