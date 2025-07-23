import sys
from collections import Counter

sys.stdin = open("./단어공부-백준/input.txt", "r")

T = int(input())

for _ in range(T):
    word = list(input().strip().upper())
    # print(word)
    count = Counter(word).most_common()
    if len(count) > 1 and count[0][1] == count[1][1]:
        print("?")
    else: print(count[0][0])