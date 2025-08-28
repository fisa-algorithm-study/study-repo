// 15m
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int init_number = Integer.parseInt(br.readLine());
        int number = init_number;
        int count = 0;

        do {
            if (number < 10)
                number = (number % 10) * 10 + (number % 10);

            else
                number = (number % 10) * 10 + ((number / 10 + number % 10) % 10);

            count++;
        } while (number != init_number) ;
//number != init_number
        System.out.println(count);
    }
}
