import java.util.*;
import java.io.*;

class Main
{
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb;
    
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new int[N + 1][N + 1];
        
        // 그래프 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        DFS(V);
        System.out.println(sb.toString());
        
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        BFS(V);
        System.out.println(sb.toString());
	}
	
	
	public static void DFS(int start) {
	    visited[start] = true;
	    sb.append(start).append(' ');
	    
	    for (int next = 1; next <= N; next++) {
	        if (graph[start][next] == 1 && !visited[next]) {
                DFS(next);
            }
	    }
	}
	
	public static void BFS(int start) {
	    Queue<Integer> q = new LinkedList<>();
	    visited[start] = true;
	    q.add(start);
	    
	    while (!q.isEmpty()) {
	        int n = q.poll();
	        sb.append(n).append(' ');
	        
	        for (int next = 1; next <= N; next++) {
                if (graph[n][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
	    
	}
	
}
