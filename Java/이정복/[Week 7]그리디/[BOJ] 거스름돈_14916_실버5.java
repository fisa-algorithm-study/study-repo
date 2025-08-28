// 10분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1, 3이라면 -1 리턴
        if (n == 1 || n == 3)
            System.out.println(-1);
        else {
            // n이 5 이하라면 2원 동전만 사용
            if (n < 5){
                System.out.println(n/2);
            }
            else {
                // 남은 잔돈이 5원 이하가 될 때까지 5원 동전을 사용하되,
                // 나머지가 2의 배수가 아니라면 (1, 3) 5원 동전 덜 사용
                if ((n % 5) % 2 == 0){
                    System.out.println((n/5) + ((n%5)/2));
                }
                else {
                    System.out.println((n/5 - 1) + (n%5 + 5)/2);
                }
            }
        }
    }
    // 찾아보니 남은 잔돈이 5의 배수가 될 때까지 2원 먼저 사용하는 것이 깔끔하다고 하네요
}
