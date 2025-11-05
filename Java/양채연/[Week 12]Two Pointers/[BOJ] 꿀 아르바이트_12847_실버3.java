import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        long[] prefix = new long[n+1];
        int start = 1 , end = m;
        long max = 0 ;

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i =0; i < n-m+1 ;i++){
            if(prefix[end]-prefix[start-1]>max){
                max = prefix[end]-prefix[start-1];
            }
            end++;
            start++;

        }
        System.out.println(max);
    }
}