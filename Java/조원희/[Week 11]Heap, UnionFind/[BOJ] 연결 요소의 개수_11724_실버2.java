import java.io.*;
import java.util.*;


public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        for(int i = 1; i <= N; i++){
            find(i);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++){
            set.add(parent[i]);
        }

        System.out.println(set.size());
        br.close();
    }


    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)   parent[y] = x;
        else parent[x] = y;
    }

    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}