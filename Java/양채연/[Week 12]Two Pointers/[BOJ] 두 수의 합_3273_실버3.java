import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0, right = n-1;
        int cnt = 0;

        while(true){
            if(left>=right) break;

            if(arr[left]+arr[right] == m){
                cnt++;
                left++;
                right--;
            }else if(arr[left]+arr[right] > m){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(cnt);
    }
}