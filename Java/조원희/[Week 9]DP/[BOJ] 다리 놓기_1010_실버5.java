import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[N][M];
            sb.append(combination(M, N)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    static int combination(int n, int r) {
        if(dp[n][r] > 0) {
            return dp[n][r];
        } else if(n == r || r == 0) {
            return dp[n][r] = 1;
        } else {
            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}