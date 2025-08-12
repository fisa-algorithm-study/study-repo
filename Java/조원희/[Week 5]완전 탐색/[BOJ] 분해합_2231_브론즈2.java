import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        for(int i = 1; i <= number; i++) {
            int num = i;
            int total = 0;

            while(num != 0){
                total += num % 10;
                num /= 10;
            }

            if(total + i == number){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}