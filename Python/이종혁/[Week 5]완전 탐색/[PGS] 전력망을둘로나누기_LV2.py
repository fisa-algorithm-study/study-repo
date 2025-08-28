from collections import deque

def solution(n, wires):

    graph = [[] for _ in range(n + 1)]
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)
    

    def bfs(start, cut_v1, cut_v2):
        q = deque([start])
        visited = {start} # 방문한 노드를 기록할 집합
        count = 1 # 연결된 노드(송전탑)의 개수
        
        while q:
            v = q.popleft()
            for neighbor in graph[v]:
                if neighbor not in visited and not ((v == cut_v1 and neighbor == cut_v2) or (v == cut_v2 and neighbor == cut_v1)):
                    visited.add(neighbor)
                    q.append(neighbor)
                    count += 1
        return count


    min_diff = n
    
    for v1, v2 in wires:
        # 끊어진 전선의 한쪽(v1)에서 시작해서 연결된 노드 개수를 센다.
        count1 = bfs(v1, v1, v2)
        
        # 다른 한쪽의 노드 개수는 전체 개수에서 빼면 된다.
        count2 = n - count1
        
        # 두 네트워크의 송전탑 개수 차이를 계산
        diff = abs(count1 - count2)
        
        # 지금까지의 최솟값과 비교하여 더 작은 값으로 갱신
        min_diff = min(min_diff, diff)
        
    return min_diff