import sys
from collections import deque

# sys.stdin = open("Python/이종혁/[Week4]트리/input.txt", "r")
# input = sys.stdin.readline 

# 정점 개수 입력
N = int(input())

# 인접 리스트(그래프) 초기화
# N+1 크기로 만드는 이유: 노드 번호가 1부터 시작하기 때문에 인덱스를 맞추기위해
graph = [[] for _ in range(N+1)]

# N-1개의 간선을 입력받아 양방향 그래프 구성
# 트리는 간선이 (노드개수-1)개 존재
for i in range(N-1):
    A, B = map(int, input().split())
    # 양방향 연결
    graph[A].append(B)
    graph[B].append(A)

# 각 노드의 부모를 저장할 배열
visited = [0] * (N+1)

def bfs(start):
    # BFS 시작 노드를 queue에 넣기
    queue = deque([start])
    
    # queue가 빌 때까지 반복
    while queue:
        # 현재 노드 꺼내기
        node = queue.popleft()
        
        # 현재 노드와 연결된 다른 노드들 확인
        for i in graph[node]:
            # 아직 방문하지 않은 노드라면 (= 부모가 정해지지 않음)
            if visited[i] == 0:
                # 부모 노드 기록
                visited[i] = node
                # 다음에 탐색할 노드로 추가
                queue.append(i)

# root 1
bfs(1)

# 2번 노드부터 N번 노드까지 부모 노드 출력
for i in range(2, N+1):
    print(visited[i])
