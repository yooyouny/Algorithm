n = int(input())
for i in range(n):
  problem, answer = map(str, input().split("="))
  if eval(problem) == int(answer):
    print('correct')
  else:
    print('wrong answer')