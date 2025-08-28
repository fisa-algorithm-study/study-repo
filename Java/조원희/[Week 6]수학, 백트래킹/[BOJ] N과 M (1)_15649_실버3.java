import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        visited = new boolean[N + 1];
        backTraking(1, N, M);

        System.out.println(sb);
        br.close();
    }

    private static void backTraking(int depth, int N, int M) {
        if(depth > M) {
            for(int i = 1; i <= M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(visited[i])  continue;
            visited[i] = true;
            arr[depth] = i;
            backTraking(depth + 1, N, M);
            visited[i] = false;
        }
    }
}