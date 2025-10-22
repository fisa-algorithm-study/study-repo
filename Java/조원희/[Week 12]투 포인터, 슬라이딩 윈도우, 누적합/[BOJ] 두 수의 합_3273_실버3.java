import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int small = 0, big = arr.length - 1, answer = 0;
        while(small < big) {
            int num = arr[big] + arr[small];

            if(num > x) {
                big--;
            } else if(num < x) {
                small++;
            } else {
                answer++;
                big--;
                small++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}