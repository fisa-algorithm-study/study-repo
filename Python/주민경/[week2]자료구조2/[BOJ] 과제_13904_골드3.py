import heapq

N = int(input())
inputList = []
answer = 0
for n in range(N):
  homework = tuple(map(int, input().split()))
  inputList.append(homework)

# 우선순위 큐
priority_queue = []
solved_date = [False for _ in range(1001)]

# 데이터 넣기
for homework in inputList:
  heapq.heappush(priority_queue, (-homework[1], homework[0]))


while priority_queue:
  homework = heapq.heappop(priority_queue)

  day = homework[1]
  for i in range(day, 0, -1):
    if solved_date[i] == False:
      solved_date[i] = True
      answer += -homework[0]
      break

print(answer)