import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken()) + arr[i - 1];
        }

        int right = 1, left = 0, len = Integer.MAX_VALUE;
        while(right <= n) {
            while(arr[right] - arr[left] >= m) {
                len = Math.min(len, right - left);
                left++;
            }
            right++;
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
        br.close();
    }
}
