from itertools import combinations
import sys

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

count = 0

for i in range(1, N + 1):
    # combinations를 이용해 arr에서 i개의 원소를 뽑는 모든 조합을 구함
    for combi in combinations(arr, i):
        # 해당 조합의 합이 S와 같다면 count 증가
        if sum(combi) == S:
            count += 1
            

print(count)

# 아래는 백트래킹 풀이

# def backtrack(index, current_sum):
#     global count
    
#     if index == N:
#         return

#     new_sum = current_sum + arr[index]
#     if new_sum == S:
#         count += 1
#     backtrack(index + 1, new_sum)
    
#     # 현재 원소(arr[index])를 포함하지 않는 경우
#     # current_sum은 변하지 않은 상태로 다음 원소로 넘어감
#     backtrack(index + 1, current_sum)


# backtrack(0, 0)

# print(count)