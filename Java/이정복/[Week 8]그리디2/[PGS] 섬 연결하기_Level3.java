import java.util.*;
import java.io.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        // 사이클 확인용 리스트
        parent = new int[n];
        for(int i=0; i<n; i++)
            parent[i] = i;

        // cost를 ArrayList 형식으로 만들기
        List<int[]> list = new ArrayList<>();
        for (int[] edge : costs) {
            list.add(edge);
        }

        // ArrayList로 만든 후 점수 오름차순/ ArrayList로 만든 후 점수 오름차순
        list.sort(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });

        // 총 비용
        int cost=0;

        // 선택된 간선이 담길 리스트
        List<int[]> selected = new ArrayList<>();

        // 모든 간선이 연결될 때까지
        while(selected.size() != n-1){
            for(int i=0; i<list.size(); i++) {
                int[] edge = list.get(i);
                if(union(edge[0], edge[1]) == true){
                    selected.add(edge);
                    list.remove(i);
                    cost += edge[2];
                    break;
                }
            }
        }

        return cost;
    }

    // 사이클이 있는지 확인
    public boolean isCycle(int n, List<int[]> selected) {
        //  Union-Find 알고리즘으로 사이클 확인
        for(int i=0; i<n; i++)
            parent[i] = i;

        for(int[] edge : selected) {
            if (union(edge[0], edge[1]) == false){
                // 사이클이 있다면 true 반환
                return true;
            }
        }
        return false;
    }

    // 노드가 연결된 집합의 대표값 탐색
    public int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // 노드가 연결된 집합을 만든다
    public boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot == yRoot)
            return false; // 대표값이 같다면 사이클이 있는 것
        parent[yRoot] = xRoot;
        return true;
    }
}