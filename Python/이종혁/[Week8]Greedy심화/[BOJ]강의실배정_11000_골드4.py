import sys
import heapq

N = int(sys.stdin.readline())

# 모든 강의 정보를 입력받아 리스트에 저장
classes = []
for _ in range(N):
    start, end = map(int, input().split())
    classes.append((start, end))

classes.sort()

# 종료 시간을 저장할 우선순위 큐
room_end_times = []

heapq.heappush(room_end_times, classes[0][1])
# 두 번째 강의부터 순회
for i in range(1, N):
    current_start, current_end = classes[i]

    # 현재 가장 빨리 끝나는 강의실의 종료 시간
    earliest_end_time = room_end_times[0]
    
    # 해당 강의실을 이어서 사용할 수 있음
    if current_start >= earliest_end_time:
        heapq.heapreplace(room_end_times, current_end)
    else:
        heapq.heappush(room_end_times, current_end)

# 힙의 크기가 필요한 최소 강의실의 개수
print(len(room_end_times))