s = input()
count = 0
result = int(s[0])
for i in range(1, len(s)):
  num = int(s[i])
  if(num <= 1 or result <= 1):
    result += num
  else:
    result *= num
print(result)
