result = 0
cnt = 0
def solution(word):
    list = []
    def dfs():
        global cnt, result
        if "".join(list) == word:
            result = cnt
            return

        if len(list) == 5:
            return

        alpha = ['A', 'E', 'I', 'O', 'U']

        for i in range(5):
            cnt += 1
            list.append(alpha[i])
            dfs()
            list.pop()

    dfs()
    return result