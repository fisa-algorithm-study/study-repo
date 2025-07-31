str = input()
# 문자열 입력
# 예) aaabbcccdddd

# 대문자로 변환
upperStr= str.upper()

# 빈도수 계산을 위한 dict 생성
frequency = {}
# { '문자' : 빈도수 }

# 문자열을 순회하며 각각 문자에 대해
for i in upperStr:
    # 
    if i in frequency:
        frequency[i] += 1
    else:
        frequency[i] = 1
# print(frequency)
# {'A': 3, 'B': 2, 'C': 3, 'D': 4}

# 빈도수 count를 위한 max_count
max_count = 0

# (A,3) (B,2) (C,3) (D,4)
# dict의 알파벳, 빈도수에 대해
for item, count in frequency.items():
#   빈도수가 max_count보다 크다면 max_count에 할당, 해당 알파벳도 할당
  if count > max_count:
    max_count = count
    freq_alphabet = item
    # 만약 동일한 빈도수라면 '?' 출력
  elif count == max_count:
    max_count = count
    freq_alphabet = '?'
print(freq_alphabet)