package tree2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 트리를 구성할 간선
    // 이 문제를 첫번째로 풀어서 자료구조랑 변수명이 좀 이상합니다..
    // 클래스명을 edge로 생각해주세요
    // a는 출발노드, b는 도착노드
    static class node{
        private int a;
        private int b;

        node(Integer a, Integer b){
            this.a = a;
            this.b = b;
        }
        public int getFrom() {
            return a;
        }

        public int getTo() {
            return b;
        }

        @Override
        public String toString() {
            return "{" + a + ", " + b + "}";
        }
    }

    // 반복문 방식으로 구현한 bfs 순회 알고리즘
    // 간선 리스트와 전체 노드 목록인 nodes, 출발 간선인 root를 입력으로 받습니다.
    public static boolean bfs (LinkedList<node> list, Set<Integer> nodes, int root) {
        Map<Integer, Boolean> checker = new TreeMap<>();
        for(Integer n : nodes){
            checker.put(n, false);
        }

        // <Integer, Integer[]> 형식의 자료구조를 만들어 from, 여러개의 to 관리
        // 예시 {1, {2, 4, 6}}    - 1은 출발노드, 2,4,6은 도착노드
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (node entry : list){
            if(map.containsKey(entry.getFrom())){
                ArrayList<Integer> newList = map.get(entry.getFrom());
                newList.add(entry.getTo());
                map.put(entry.getFrom(), newList);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(entry.getTo());
                map.put(entry.getFrom(), newList);
            }
        }

        // bfs탐색 진행
        // queue에 root부터 노드들 삽입
        // queue에서 꺼내면서 탐색하며 checker 업데이트
        // 탐색 도중 이미 cherker가 true인 노드가 다시 한번 나왔다면 false return
        // 탐색이 끝났을 때 checker에 false가 있다면 false return
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            checker.put(curr, true);
            if(map.containsKey(curr)){
                for (int child : map.get(curr)){
                    if(checker.get(child) == true)
                        return false;
                    queue.add(child);
                }
            }
        }

        if(checker.containsValue(false))
            return false;

        // 결과 리턴
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int num = 1;

        boolean isFinished = false;
        while(!isFinished) {
            LinkedList<node> list = new LinkedList<>();
            boolean isTree = true;

            while(true){
                // 한 줄 tokenizer로 받아오기
                if (st == null || !st.hasMoreTokens()){
                    String s = br.readLine();
                    st = new StringTokenizer(s);
                    if (!st.hasMoreTokens()) continue;
                }

                // 받아온 토큰들에 대해 두개씩 짝짓기
                if (!st.hasMoreTokens()) break;
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // 0 0이면 break
                if (u == 0 && v == 0){
                    break;
                }
                // 음수 음수면 isfinish true, break
                else if (u < 0 && v < 0) {
                    isFinished = true;
                    break;
                }
                list.add(new node(u, v));
            }
            // 음수를 받았다면 종료
            if (isFinished){
                break;
            }

            // 비어있는 트리의 경우 트리로 간준
            if (list.isEmpty()) {
                System.out.printf("Case %d is a tree.\n", num++);
                continue;
            }
            
        /**
            지금부터 트리 판별 알고리즘입니다.
            1. 루트 노드는 하나만 존재한다.
                - 진입차수가 0인 노드가 없거나 2개 이상 있으면 트리 아님
            2. 루트를 제외한 모든 노드는 부모노드를 하나만 갖는다. (진입 차수를 1만 갖는다.)
                - 진입차수가 2 이상인 노드가 있으면 트리 아님
            3. 트리에는 사이클이 있으면 안된다.
                - 트리 순회 중 방문한 노드를 다시 방문했다면 트리 아님
            4. 모든 노드는 연결되어 있어야 한다.
                - 트리 순회가 완료되었는데 방문하지 않은 노드가 있다면 트리 아님
        */
            

            // list를 순회하며 진입 간선이 있을 때마다 degree ++
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> nodes = new HashSet<>();
            for (node n : list){
                int from = n.getFrom();
                int to = n.getTo();
                nodes.add(from);
                nodes.add(to);

                map.put(to, map.getOrDefault(to, 0) + 1);
                map.putIfAbsent(from, 0);
            }

            int rootCount = 0;
            int root = 0;
            for (int node : nodes) {
                int degree = map.getOrDefault(node, 0);
                if (degree == 0){
                    rootCount++;
                    root = node;
                }
                // 진입차수가 1 초과인 노드가 있다면 트리가 아님
                else if (degree != 1){
                    isTree = false;
                }
            }
            // 루트 노드가 여러개라면 트리가 아님
            if (rootCount != 1){
                isTree = false;
            }

            // bfs 방식으로 체크
            // (모든 노드가 방문되지 않음 > 분리된 트리가 존재)
            // (이미 방문한 노드가 다시 나옴 > 사이클 존재)
            if(bfs(list, nodes, root) == false)
                isTree = false;

            if (isTree) {
                System.out.printf("Case %d is a tree.\n", num);
            } else {
                System.out.printf("Case %d is not a tree.\n", num);
            }
            num++;
        }
    }
}