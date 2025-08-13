import java.util.Scanner;

class Main
{
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int result = 0;
        
        for (int i = N - 1; i > 0; i--) {
            int n = i;
            int sum = i;
            
            while (n > 0) {
                sum += (n % 10);
                n /= 10;
            }
            
            if (sum == N) {
                result = i;
            }
        }
        
        System.out.println(result);
        
		sc.close();
	}
}