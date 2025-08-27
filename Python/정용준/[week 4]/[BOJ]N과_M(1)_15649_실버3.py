import sys
from itertools import permutations
sys.stdin = open('input3.txt', 'r')

n, m = map(int, input().split())
arr = list(range(1,n+1))
# 순열 딸-각
perm =  list(permutations(arr,m))

# 4개짜리 5개짤리 이렇게하면 너무 많아서 언패킹이 안됨
# for a, b in perm:
#     print(a, b)

for p in perm:
    print(*p)  # *p로 튜플 언패킹


# 
