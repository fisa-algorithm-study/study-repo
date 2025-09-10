package week9.bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cases = Integer.parseInt(br.readLine());

        // 모든 케이스에 대해 반복
        for(int currentCase=0; currentCase<cases; currentCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            memoization = new int[n+1][m+1];    // 0으로 초기화됨

            System.out.println(DP(n, m));   // 결과 리턴
        }
    }

    private static int DP(int n, int m) {
        // 재귀 완료 조건
        if (n == 1) {
            memoization[n][m] = m;
            return m;
        }
        if (n == m) {
            memoization[n][m] = 1;
            return 1;
        }

        // 기억하고 있는 값이 있는지 확인하고 사용
        int a = memoization[n][m-1];
        int b = memoization[n-1][m-1];

        // 기억하고 있는 값이 없다면 재귀
        if (a == 0)
            a = DP(n, m-1);
        if(b == 0)
            b = DP(n-1, m-1);

        // 하위 문제들의 답을 더해 리턴
        memoization[n][m] = a + b;
        return a + b;
    }
}
