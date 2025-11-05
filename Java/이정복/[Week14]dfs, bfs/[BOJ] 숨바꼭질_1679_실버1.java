import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    의문점
        해당 로직은 최소 깊이를 찾는 것이 아닌, 가장 먼저 만난 상황에서의 깊이를 찾는 로직
        채점을 했을 때는 정답으로 나오기는 하는데, 이유가 무엇일지 고민해봐도 모르겠습니다.
 */

public class Main {
    private static Queue<int[]> queue = new LinkedList<>();
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int soobin =  Integer.parseInt(st.nextToken()); // 수빈이 출발하는 위치
        int sister = Integer.parseInt(st.nextToken());  // 동생의 위치

        // 수빈이 출발하는 지점을 깊이 0으로 세팅
        queue.add(new int[]{soobin, 0});
        visited[soobin] = true;
        System.out.println(bfs(sister));
    }

    // 현재 점의 정수를 큐에 넣으며 bfs 탐색을 진행한다.
    private static int bfs(int sister) {
        int curr, temp, depth=0;

        while (!queue.isEmpty()) {
            // 큐에서 현재 지점과 깊이를 가져옴
            int[] data = queue.poll();
            curr = data[0];
            depth = data[1];

            // 동생을 만났다면 깊이 리턴
            if(sister == curr)
                return depth;

            // 가능한 연산들을 큐에 추가
            temp = curr * 2;
            if(temp <= 100000 && visited[temp] == false) {
                queue.add(new int[]{temp, depth + 1});
                visited[temp] = true;
            }

            temp = curr - 1;
            if(temp >= 0 && visited[temp] == false){
                queue.add(new int[]{temp, depth + 1});
                visited[temp] = true;
            }

            temp = curr +1;
            if(temp <= 100000 && visited[temp] == false){
                queue.add(new int[]{temp, depth + 1});
                visited[temp] = true;
            }
        }
        // 탐색실패, 문제 조건 상 도달할 수는 없음
        return -1;
    }
}