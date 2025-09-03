import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int five = n / 5;
        int result = 50000;
        
        for (int i = five; i >= 0; i--) {
            int remain = n - i * 5;
            
            if (remain % 2 == 0) {
                int two = remain / 2;
                
                result = Math.min(result, (i + two));
                
                break;
            }
        }
        
        System.out.println(result == 50000 ? -1 : result);
        
    }
    
}