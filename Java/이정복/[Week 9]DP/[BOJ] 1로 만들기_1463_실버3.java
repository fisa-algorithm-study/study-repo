package week9.ToOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] memoization;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memoization = new int[n+1]; // 0으로 초기화됨
        System.out.println(DP(n));
    }

    private static int DP(int n) {
        // 재귀 완료 조건
        if(n == 1)
            return 0;

        int min = 99999;
        int curr = 0;

        // 3 나누기 연산
        if ((n % 3) == 0){
            curr = memoization[n/3];
            if(curr == 0)
                curr = DP(n/3);
            if(min > curr)
                min = curr;
        }

        // 2 나누기 연산
        if ((n % 2) == 0){
            curr = memoization[n/2];
            if(curr == 0)
                curr = DP(n/2);
            if(min > curr)
                min = curr;
        }

        // 1 빼기 연산
        curr = memoization[n-1];
        if(curr == 0)
            curr = DP(n-1);
        if(min > curr)
            min = curr;

        // memoization 업데이트와 return
        memoization[n] = min + 1;
        return memoization[n];
    }
}
