import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        boolean[] visited = new boolean[MAX + 1];
        int[] arr = new int[MAX + 1];

        Queue<Integer> q = new LinkedList<>();
        visited[N] = true;
        q.add(N);

        while (!q.isEmpty()) {
            int start = q.poll();
            
            if (start == K) {
                System.out.println(arr[start]);
                return;
            }

            int[] next = {start - 1, start + 1, start * 2};
            for (int n : next) {
                if (0 <= n && n <= MAX && !visited[n]) {
                    visited[n] = true;
                    arr[n] = arr[start] + 1;
                    q.add(n);
                }
            }
        }
        
    }
    
}
