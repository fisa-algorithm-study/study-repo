import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[x + 1];
        arr[1] = 0;

        for (int i = 2; i <= x; i++) {
            if(i%6==0){
                arr[i] = Math.min(Math.min(arr[i/3]+1,arr[i/2]+1),arr[i-1]+1);
            }else if(i%3==0){
                arr[i] = Math.min(arr[i/3]+1, arr[i-1]+1);
            }else if(i%2==0){
                arr[i] = Math.min(arr[i/2]+1, arr[i-1]+1);
            }else{
                arr[i] = arr[i-1]+1;
            }
        }
        System.out.println(arr[x]);

    }
}
