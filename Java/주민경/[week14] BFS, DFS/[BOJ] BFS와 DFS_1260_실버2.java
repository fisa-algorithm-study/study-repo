import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N + 1];
        DFS(graph, V, visited);
        System.out.println();

        visited = new boolean[N + 1];
        BFS(graph, V, visited);
    }

    // DFS
    public static void DFS(List<List<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int next : graph.get(v)) {
            if (!visited[next]) {
                DFS(graph, next, visited);
            }
        }
    }

    // BFS
    public static void BFS(List<List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            for (int next : graph.get(v)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
