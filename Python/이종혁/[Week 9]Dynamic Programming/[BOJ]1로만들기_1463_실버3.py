import sys

# number = int(sys.stdin.readline())

# result = number
# count = 0
# for i in range(number):
#     if number % 3 == 0:
#         result = number / 3
#         count +=1
#     elif number % 2 == 0:
#         result = number / 2
#         count +=1
#     else :
#         result -= 1
#         count+=1

# memo = [0] * 11

# def fibo_memo(x):
#     # 종료 조건
#     if x == 1 or x == 2:
#         return 1
#     # 이미 계산한 적 있는 문제라면 메모된 값 반환
#     if memo[x]!= 0:
#         return memo[x]
#     # 아직 계산하지 않은 문제라면 점화식에 따라 계산하고 메모
#     memo[x] = fibo_memo(x - 1) + fibo_memo(x - 2)
#     return memo[x]

# print(fibo_memo(10))
# print(10)

# Bottom-up
N = int(sys.stdin.readline())

dp = [0] * (N + 1)

for i in range(2, N + 1):
    # 1을 빼는 경우: 이전 숫자(i-1)의 연산 횟수에 1을 더함.
    dp[i] = dp[i - 1] + 1
    
    # 2로 나누어 떨어지는 경우:
    # 기존의 최솟값(1을 뺀 경우)과 2로 나눈 숫자의 연산 횟수+1을 비교하여 더 작은 값으로 갱신.
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
        
    # 3으로 나누어 떨어지는 경우:
    # 기존의 최솟값과 3으로 나눈 숫자의 연산 횟수+1을 비교하여 더 작은 값으로 갱신.
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)


print(dp[N])