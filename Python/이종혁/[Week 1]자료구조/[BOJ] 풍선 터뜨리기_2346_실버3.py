
# (1,3) (2,2) (3,1) (4,-3) (5,-1) =>1

# (2,2) (3,1) (4,-3) (5,-1)  =>4

# (2,2) (3,1) (5,-1) =>5

# (2,2) (3,1) =>3

# (2,2) =>2

# 출력 : [ 1, 4, 5, 3, 2]

# 입력부
n = int(input())
nums = list(map(int, input().split()))


balloons = [(i + 1, move) for i, move in enumerate(nums)]  # (번호, 이동수)
#  (1,3) (2,2) (3,1) (4,-3) (5,-1)
print(balloons)
result = []

index = 0  # 현재 가리키는 인덱스

while balloons:
    num, move = balloons.pop(index)  # 풍선 터뜨리기

    result.append(num)

    if not balloons:
        break  # 풍선 다 터졌으면 끝

    # 이동할 인덱스 계산
    # 리스트에서 풍선을 pop하면, 그 풍선은 사라지고 그 다음 풍선이 자동으로 앞으로 당겨짐

    if move > 0:
        # 그래서 -1을 해야함
        index = (index + move - 1) % len(balloons)
    else:
        # 뺏을때는 -1 안해도 나머지로 연산
        index = (index + move) % len(balloons)  # move는 음수니까 그대로 더해도 됨

# 공백 구분 하나씩 요소 나열
print(*result)

# 다른 자료구조 풀이(덱, deque) 원래 덱 쓰라고 만든 문제인듯..(시간초과날듯 잘못하면)

# pop()이나 append()는 리스트 끝에서는 빠르지만, (O(1))

# 리스트 앞쪽에서 insert(0, x)나 pop(0)은 느림 (O(N))

# deque는 양쪽 모두 빠르다 (O(1))

# from collections import deque
# dq = deque((i + 1, num) for i, num in enumerate(nums))
# #  (풍선번호, 이동할 칸 수) 
# #  예제 입력
# #  5 , 3 2 1 -3 -1
# #  (1,3) (2,2) (3,1) (4,-3) (5,-1)
# #  위 튜플들을 deque에 순서대로 넣는다.
# for i, num in enumerate(nums):
#     print(i, num)

# result = []

# while dq:
#     index, move = dq.popleft()
#     result.append(index)

#     if not dq:
#         break

#     # 회전하며 pop()
#     if move > 0:
#         for _ in range(move - 1):
#             dq.append(dq.popleft())
#     else:
#         for _ in range(-move):
#             dq.appendleft(dq.pop())

# print(' '.join(map(str, result)))
