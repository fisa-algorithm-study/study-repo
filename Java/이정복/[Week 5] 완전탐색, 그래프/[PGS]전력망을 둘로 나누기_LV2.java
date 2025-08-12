import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    // 하나하나 끊어보면서 탐색
    public int solution(int n, int[][] wires) {
        // Map<Integer, Set<Integer>> 형태 만들기
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        // wires에서 하나씩 골라가며 끊으면서 양쪽 dfs
        Map<Integer, Set<Integer>> tempGraph;
        int min = 999;
        // 모든 간선에 대해
        for (int[] wire : wires) {
            // wire를 끊을 임시 Map 생성
            tempGraph = new HashMap<>(graph);
            // 그냥 복사 시 Map 내부의 Set 주소까지 복사되기 때문에
            // Set까지 복사를 해줘야함 (얕은 복사 > 깊은 복사)
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                tempGraph.put(entry.getKey(), new HashSet<>(entry.getValue()));
            }

            // 선택한 간선 제거하기
            tempGraph.get(wire[0]).remove(wire[1]);
            tempGraph.get(wire[1]).remove(wire[0]);

            // 제거한 간선의 두 연결 노드를 시작으로 dfs 탐색 > 연결된 노드 수를 구함
            Set<Integer> visited1 = new HashSet<Integer>();
            dfs(wire[0], tempGraph, visited1);
            int connectedRight = visited1.size();

            Set<Integer> visited2 = new HashSet<Integer>();
            dfs(wire[1], tempGraph, visited2);
            int connectedLeft = visited2.size();

            // 차이값을 구하고, 지금까지 구한 최소값이랑 비교 후 업데이트
            int curValue = Math.abs(connectedRight - connectedLeft);
            if (min > curValue){
                min = curValue;
            }
        }
        // 두 그래프의 차이의 최소값 리턴
        return min;
    }

    public void dfs(int node, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        // 재귀적으로 접근
        // 지금 노드 방문 처리하기
        if (visited.contains(node))
            return;

        visited.add(node);

        // 현재 노드에 연결된 노드들 가져오기
        Set<Integer> childs = graph.get(node);

        // 아직 방문하지 않은 연결된 노드에 대해 dfs
        for (int child : childs) {
            dfs(child, graph, visited);
        }
    }
}
