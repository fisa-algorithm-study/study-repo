import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int firstNum = n;
        int newNum = 0;
        int cycle = 0;


        while (true) {
            newNum = (n % 10) * 10 + (n / 10 + n % 10) % 10;
            cycle++;

            if (firstNum == newNum) break;
            n = newNum;
        }

        System.out.println(cycle);


    }
}
