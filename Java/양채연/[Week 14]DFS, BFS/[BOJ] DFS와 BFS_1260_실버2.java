import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Integer>[] dfs;
    static List<Integer>[] bfs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        dfs = new ArrayList[N+1];
        bfs = new ArrayList[N+1];
        for(int i = 1; i <= N ; i++){
            dfs[i] = new ArrayList<>();
            bfs[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dfs[u].add(v);
            dfs[v].add(u);
            bfs[u].add(v);
            bfs[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(dfs[i]);
            Collections.sort(bfs[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        System.out.println();
        Arrays.fill(visited,false);
        BFS(V);
    }

    static void DFS(int v){
        visited[v] = true;
        System.out.print(v + " ");
        for(int nxt : dfs[v]){
            if(!visited[nxt]){
                DFS(nxt);
            }
        }
    }

    static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur+ " ");
            for(int nxt: bfs[cur]){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }
    }
}