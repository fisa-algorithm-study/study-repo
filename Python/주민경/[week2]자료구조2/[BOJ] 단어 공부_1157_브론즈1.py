alphabetDict = {}
alphabets = input()

# 아스키코드를 사용하여 대문자 : 0의 사전 만들기
for i in range(65, 91):
  alphabetDict[chr(i)] = 0

# 문자열을 순회하며 소문자, 대문자 관계없이 같은 alphabet 키의 value 넣기
for alphabet in alphabets:
  if alphabet.isupper():
    alphabetDict[alphabet] += 1
  else:
    ch = chr(ord(alphabet)-32)
    alphabetDict[ch] += 1

# max 출력
max_value = max(alphabetDict.values())
max_keys = [k for k, v in alphabetDict.items() if v == max_value]

# max가 여러 개일 경우
if len(max_keys) > 1:
  print('?')
else:
  print(max_keys[0])