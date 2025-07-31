# Note : Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 
# 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다. 

import sys

# 단어 개수, 외우는 단어 길이
word_count, word_length = map(int, sys.stdin.readline().split())

# 단어 리스트
words_list = [sys.stdin.readline().strip() for i in range(word_count)]

# word_length 이상 단어만 넣을 리스트
more_words_list = []

# 사전 오름차순 정렬
words_list.sort()

# 외울 길이 이상 리스트 append
for word in words_list:
    if (len(word)>=word_length):
        more_words_list.append(word)


# 빈도수 계산을 위한 딕셔너리 
frequency = dict()

for word in more_words_list:
    if word in frequency:
        frequency[word] +=1
    else:
        frequency[word] = 1

# 정렬:
# 1) 등장 횟수 많은 순 (-frequency[word])
# 2) 단어 길이 긴 순 (-len(word))
# 3) 사전순 오름차순

sorted_words = sorted(frequency.keys(), key=lambda x: (-frequency[x], -len(x), x))

for word in sorted_words:
    print(word)




