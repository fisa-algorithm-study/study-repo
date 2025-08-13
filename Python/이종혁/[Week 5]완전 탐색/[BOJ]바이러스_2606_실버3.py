import sys
from collections import deque
# 컴퓨터 개수
computer_num = int(sys.stdin.readline().strip())
# 쌍 개수
pair_num = int(sys.stdin.readline().strip())

# 인접 그래프
graph = [[] for _ in range(computer_num + 1)]

for _ in range(pair_num):
    a,b = list(map(int, sys.stdin.readline().strip().split()))
   
    graph[a].append(b)
    graph[b].append(a)


visited = [False] * (computer_num + 1)

# print(graph)

def bfs(start):
    
    count = 0
    
    queue = deque([start])
    
    # 시작 노드 방문 처리
    visited[start] = True
    
    while(queue):
        node = queue.popleft()
        
        for i in graph[node]:
            
            #  방문하지 않은 노드라면
            if not visited[i]:
                queue.append(i)
                # 방문처리
                visited[i] = True
                
                count +=1
    return count 
 
result = bfs(1)

print(result)


                
        
