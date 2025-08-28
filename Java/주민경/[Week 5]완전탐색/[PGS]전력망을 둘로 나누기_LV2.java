import java.io.*;
import java.util.*;

class Solution {
    private static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        int answer = 1000000000;

        // 그래프
        for (int i = 0; i < wires.length; i++) {
            map.putIfAbsent(wires[i][0], new ArrayList<>());
            map.putIfAbsent(wires[i][1], new ArrayList<>());
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            // 간선 제거
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));
            
            // BFS
            boolean[] visited = new boolean[n+1];
            int linkedNumbers = bfs(visited, map, a);
            int diff = Math.abs(linkedNumbers - (n - linkedNumbers));
            answer = Math.min(answer, diff);
            
            // 간선 복구
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return answer;
    }
    
    public int bfs(boolean[] visited, Map<Integer, ArrayList<Integer>> graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int count = 1;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int node : graph.get(current)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    count++;
                }
            }
        }
        return count;
    }
}
