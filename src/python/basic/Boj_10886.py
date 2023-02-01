num = int(input())
cute = int()
not_cute = int()
for i in range(num):
  search = int(input())
  if(search == 0):
    not_cute++
  else:
    cute++
if(cute>not_cute):
  print('Junhee is cute!')
else:
  print('Junhee is not cute!')
