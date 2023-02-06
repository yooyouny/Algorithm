s = input()
tozero_cnt = 0
toone_cnt = 0

if s[0] == '1':
  tozero_cnt += 1
else:
  toone_cnt += 1

for i in range(len(s)-1) :
  if(s[i] != s[i+1]):
    if(s[i+1] == '1'):
        tozero_cnt += 1
    else:
      toone_cnt += 1

print(min(toone_cnt, tozero_cnt))
