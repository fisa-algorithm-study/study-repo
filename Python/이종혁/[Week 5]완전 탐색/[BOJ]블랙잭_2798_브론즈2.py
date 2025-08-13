import sys
# sys.stdin = open("C:/study-repo/Python/이종혁/[Week 5]/input_1.txt", "r")
# input = sys.stdin.readline 

N, M = map(int, sys.stdin.readline().split())

cards = list(map(int, sys.stdin.readline().split()))

total = 0

answer = 0
for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            total = cards[i] + cards[j] + cards[k]
            if( total <= M):
                answer = max(total, answer)

print(answer)
         



