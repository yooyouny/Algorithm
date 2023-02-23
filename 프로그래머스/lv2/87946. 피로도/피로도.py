from itertools import permutations

def solution(k, dungeons):
    idx = list(range(len(dungeons)))
    candidates = list(permutations(idx, len(dungeons)))
    max_dungeon = -1
    for candidate in candidates: # 012 021 102
        dungeon = 0
        now = k
        for index in candidate: # 0 2 1
            minimum, consume = dungeons[index]
            if now >= minimum:
                now -= consume
                dungeon += 1
        max_dungeon = max(max_dungeon, dungeon)
    return max_dungeon