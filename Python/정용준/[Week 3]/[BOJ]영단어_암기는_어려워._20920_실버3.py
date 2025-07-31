import sys
from collections import Counter

sys.stdin = open('input2.txt', 'r')

# 필터 해줘서 m 보다 작은거 없애고 순서를 1. 중복 2. 글자수 길수록 3. a-z 순

# 시간 초과가 뜬다면 더빠르게 동작
input = sys.stdin.readline

n, m = map(int, input().split())

counter = Counter()

for i in range(n):
    word = input().strip()
    if len(word) >= m:
        counter[word] += 1
 
# 객체=> 튜플 [바로 비교 할려고] 객체로 비교할려면 귀찮음 
# 바꾸고 정렬: 1. 내림차순 2. 길이 내림차순 3. 알파벳 오름차순
# sorted(data, key=lambda x: 정렬기준) 

sorted_words = sorted(counter.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for word, _ in sorted_words:
    print(word)
