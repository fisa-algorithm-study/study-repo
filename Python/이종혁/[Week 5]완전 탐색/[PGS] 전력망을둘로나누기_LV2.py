def solution(n, wires):
    answer = -1
    
    graph = [[] for _ in range(n+1)]
    
    # 반복문으로 간선을 끊고, 나누어진 개수를 구한다?
    # 아니면 가장 많은 간선을 가진 노드에서 간선을 끊을 것을 구한다?
    
    for i in range(len(wires)):
        graph[wires[i][0]].append(wires[i][1])
        graph[wires[i][1]].append(wires[i][0])
    
    for i in range(len(wires)-1):
        
    # print(graph)
        return answer