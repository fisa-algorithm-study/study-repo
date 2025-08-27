import sys

sys.stdin = open('input2.txt', 'r')

n, k = map(int, input().split())

# 소수 판별 함수 너무 기얼서 개빡침 암기 ㄱㄱ
소수판별 = lambda n: n > 1 and all(n % i != 0 for i in range(2, int(n**0.5) + 1))

arr = list(range(2, n+1))  # [2,3,...,n]
count = 0

for i in range(2, n+1):
    if 소수판별(i):  # 남아 있는 i가 소수면  i = 2,3,4, .. 7
        # i의 배수 제거
        for j in arr:  
            if j % i == 0: #  2 % 2 == 0  , 4 % 2 == 0
                arr.remove(j) # [2,3,4,5,6,7] => [3,4,5,6,7] / [3,4,5,6,7] => [3,5,6,7] ...
                count += 1
                if count == k:
                    print(j)


