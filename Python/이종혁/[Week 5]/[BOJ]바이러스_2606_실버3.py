import sys

computer_num = int(sys.stdin.readline().strip())
pair_num = int(sys.stdin.readline().strip())
pairs = []
for _ in range(pair_num):
    a,b = list(map(int, sys.stdin.readline().strip().split()))
    pairs.append((a,b))

visted = [False] * (computer_num + 1)
def bfs(computer_num, pair_num, pairs):
    