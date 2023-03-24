from itertools import permutations
def solution(k, dungeons):
    max_value = -1e9
    candidates = list(permutations(dungeons, len(dungeons)))
    for candidate in candidates:
        answer = 0
        now = k
        for minimum, consume in candidate:
            if now >= minimum:
                now -= consume
                answer += 1
                continue
        max_value = max(max_value, answer)
    return max_value