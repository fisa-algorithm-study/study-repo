import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static int max = 0;
    public static void main(String args[]) throws Exception {
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" "); */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정점의 개수
        int M = Integer.parseInt(br.readLine()); // 간선의 개수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) { 
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[N+1];
        int answer = bfs(graph, visited);
        System.out.println(answer);
    }

    public static int bfs(List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int sum = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer g : graph.get(current)) {
                if (!visited[g]) {
                    visited[g] = true;
                    queue.add(g);
                    sum++;
                }
            }
        }
        return sum;
    }
}