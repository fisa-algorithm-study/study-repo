import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        DP(N, 0);

        System.out.println(dp[1]);
        br.close();
    }

    private static void DP (int n, int count) {
        if(dp[n] < count) {
            return;
        }
        dp[n] = count;
        if(n % 3 == 0){
            DP(n / 3, count + 1);
        }
        if(n % 2 == 0){
            DP(n / 2, count + 1);
        }
        if(n > 1) {
            DP(n - 1, count + 1);
        }
    }
}