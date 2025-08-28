import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            map.putIfAbsent(i, new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.get(n).add(v);
            map.get(v).add(n);
        }

        visited = new boolean[N + 1];
        DFS(1);

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i])    answer++;
        }

        System.out.println(answer - 1);
        br.close();
    }

    private static void DFS(int node){
        visited[node] = true;
        for(int value: map.get(node)) {
            if(visited[value])  continue;
            DFS(value);
        }
    }
}