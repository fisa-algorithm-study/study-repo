import sys

sys.stdin = open('input.txt', 'r')

n = int(input())
# n=13

# for i in range(n // 2 + 1):
#     for j in range(n // 2 + 1):
#         if(2*i + 5*j == n):
#             print(i+j)

# => 문제 조건이 10^5 이므로 시간초과
# 2i + 5j = n ==> j =(n-2i)/5
# 2i < n ... i<n//2
for i in range(0,n // 2 + 1):
    if (n - 2*i) % 5 == 0:  # j가 정수인지 확인  , 2i + 5j = n ==> j =(n-2i)/5
        j = (n - 2*i) // 5
        print(i + j)
        break
else:
    print(-1)  # 불가능한 경우
