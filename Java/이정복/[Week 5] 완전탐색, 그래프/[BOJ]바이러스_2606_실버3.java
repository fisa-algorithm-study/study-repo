import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 방문한 노드들을 넣을 Set
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computers = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        // Map<Integer, Set<Integer>> 형식으로 그래프 구현
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // Map 요소들을 초기화한 뒤
        for(int i=1; i<=computers; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        // 간선들을 Map에 적용
        for(int i=0; i<edges; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 탐색
        dfs(1, graph);

        // 1을 제외하고 출력해야하기 때문에 1을 뺀 값 출력
        System.out.println(visited.size() - 1);
    }

    private static void dfs(int curNode, Map<Integer, Set<Integer>> graph) {
        // 방문처리
        if (!visited.contains(curNode))
            visited.add(curNode);

        // 지금 방문중인 노드와 연결된 노드들을 탐색
        for(int i : graph.get(curNode)){
            // 무한루프 방지를 위해 visited에 연결된 노드가 있는지 확인한 후 dfs
            if(!visited.contains(i))
                dfs(i, graph);
        }
    }
}
