def solution(array, commands):
    answer = []
    for command in commands:
        slicing = array[command[0]-1:command[1]]
        slicing.sort()
        answer.append(slicing[command[2]-1])
    return answer