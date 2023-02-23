cnt = 0
result = 0
def solution(word):
    def dfs(list):
        global result, cnt

        if "".join(map(str, list)) == word:
            result = cnt
            return
        
        if len(list) == 5:
            return
        
        alpha = ['A', 'E', 'I', 'O', 'U']
        
        for i in range(5):
            cnt += 1
            list.append(alpha[i])
            dfs(list)
            list.pop()
            
            
    dfs([])
    return result
 