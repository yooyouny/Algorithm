word = input()
answer = ''
for i in range(0, len(word)):
  if word[i].isupper():
    answer += word[i].lower()
  else:
    answer += word[i].upper()
print(answer)