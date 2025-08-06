N = int(input())
# N = 7
d_w = [list(map(int, input().split())) for _ in range(N)]
# d_w = [[4, 60], [4, 40], [1, 20], [2, 50], [3, 30], [4, 10], [6, 5]]

# 점수(score) 순으로 내림차순 정렬
d_w.sort(key=lambda x:-x[1])
#  [[4, 60], [2, 50], [4, 40],[3, 30], [1, 20],  [4, 10], [6, 5]]


# 최대 점수
sum_score = 0

schedule = [0] * 1001  # 0~1000 인덱스 배열 선언(입력 조건 1<=d<=1000)
for deadline, score in d_w:
    # deadline부터 거꾸로 반복 (4, 3, 2, 1 ,2 ,1...)
    for day in range(deadline, 0, -1):
        # 아직 아무것도 안한 날이라면,
        if(schedule[day] == 0):
            # 해당 날짜에 score 할당
            schedule[day] = score
            # 점수 더하고,
            sum_score += score
            # 바로 위 반복문 빠져나옴
            break
print(sum_score)

# 예제를 예로 든다면, schedule[4] = 60 ,schedule[2] = 50, schedule[3] = 40, schedule[1] = 30, schedule[6] = 5 
# 최종적으로, sum_score = 185

