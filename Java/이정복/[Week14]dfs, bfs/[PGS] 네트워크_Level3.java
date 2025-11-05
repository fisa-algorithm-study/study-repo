import java.util.HashSet;

class Solution {
    private static int n;
    private int[][] computers;
    
    // 접근 : UNION-FIND?
    // 알고리즘 정석대로 풀지는 않고,(Union을 만들어주지 않고)
    // 연결된 네트워크에서 가장 큰 값을 갖는 노드를 대표값으로 설정하고 
    // 완성된 대표값의 종류를 세는 방법으로 해결했습니다.
    // GPT한테 물어보니깐 이 로직은 실제 Union-Find처럼 방향 그래프까지 커버하지는 못한다고 하네요
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        int[] represent = new int[n];

        // 대표값을 자기 자신으로 초기화
        for (int i = 0; i < n; i++) {
            represent[i] = i;
            System.out.printf("%d ", represent[i]);
        }
        System.out.println();
        
        // 각 노드마다 DFS 돌려서 '해당 노드가 속한 것의 최대 인덱스'를 대표값으로 저장
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];      // i마다 방문 기록 새로
            int max = findMaxDFS(visited, i);
            represent[i] = max;              // i의 대표값은 max라고 가정
            System.out.printf("%d -> %d%n", i, max);
        }

        // represent 배열 안에 있는 값들의 고유 개수 세기
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(represent[i]);
        }

        int answer = set.size();
        System.out.println("distinct reps = " + answer);

        return answer;
    }
    
    // 각 노드에 대해 탐색할 때마다 visited를 초기화해야함
    int findMaxDFS(int[] visited, int curr) {
        // 지금 노드를 방문처리
        visited[curr] = 1;
        int max = curr;
        
        // curr에서 갈 수 있는 모든 노드 탐색
        for (int i = 0; i < n; i++) {
            // 연결되어 있고 아직 방문 안 했으면 DFS 진행
            if (computers[curr][i] == 1 && visited[i] == 0) {
                int childMax = findMaxDFS(visited, i);
                if (max < childMax) {
                    max = childMax;
                }
            }
        }
        
        return max;
    }
}
