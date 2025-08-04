package tree3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 트리 구성에 사용할 노드
    // 노드 ID와 연결된 노드들의 리스트로 구성되어 있습니다
    // 부모도 children에 들어가는데, 순회 시 checked Set을 이용해 부모 자식을 구분했습니다.
    public static class Node{
        private int ID;
        private ArrayList<Node> children;

        Node(int ID) {
            this.ID = ID;
            children = new ArrayList<>();
        }

        public int getID() {
            return ID;
        }

        public ArrayList<Node> getChildren(){
            return children;
        }
    }

    // bfs 방식으로 순회, 이번에는 반복문 방식으로 작성해봤습니다.
    public static int[] bfs(Map<Integer, Node> map) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] parents = new int[map.size() + 1];

        queue.add(1);

        // 큐가 다 빌 때까지
        while(!queue.isEmpty()){
            // 큐의 항목을 꺼내 방문 표시한 후
            int cur = queue.poll();
            visited.add(cur);

            // 아직 방문하지 않은 연결된 노드들을 큐에 삽입
            // 해당 노드의 부모 노드를 표시하는 parents 배열에 cur 삽입
            Node curNode = map.get(cur);
            for(Node child : curNode.getChildren()){
                if (visited.contains(child.getID())) continue;
                else {
                    parents[child.getID()] = cur;
                    queue.add(child.getID());
                }
            }
        }
        return parents;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        // 입력, Node와 Node를 담을 map에 형식에 맞게 넣습니다.
        Map<Integer, Node> map = new HashMap<>();
        for (int i=1; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            Node fromNode;
            if(map.containsKey(from)){
                fromNode = map.get(from);
            } else {
                fromNode = new Node(from);
                map.put(from, fromNode);
            }

            Node toNode;
            if(map.containsKey(to)){
                toNode = map.get(to);
            } else {
                toNode = new Node(to);
                map.put(to, toNode);
            }

            fromNode.getChildren().add(toNode);
            toNode.getChildren().add(fromNode);
        }

        // bfs 탐색 후 출력
        int[] parents = bfs(map);
        for (int i = 2; i<=num; i++){
            System.out.println(parents[i]);
        }
    }
}