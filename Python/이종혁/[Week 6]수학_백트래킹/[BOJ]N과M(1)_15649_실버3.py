from itertools import permutations
import sys

N, M = map(int, sys.stdin.readline().split())

arr = []
for i in range(N):
    arr.append(i + 1)

for i in permutations(arr, M):
    # 언패킹
    print(*i)