s = input()
alpa = ''
num = 0
for i in s:
  if(i.isdigit()):
    num += int(i)
  else:
    alpa += str(i)
result = ''.join(sorted(alpa))
print(result+str(num))

