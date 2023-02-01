t = int(input());
for i in range(t):
  num, word = input().split();
  result = ''
  for ch in word:
    result += int(num) * ch
  print(result)

