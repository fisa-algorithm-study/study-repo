import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        int num = N;
        do {
            count++;
            num = (num % 10) * 10 + ((num / 10) + (num % 10)) % 10;
        } while(num != N);

        System.out.println(count);
        br.close();
    }
}