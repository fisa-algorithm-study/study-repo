import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken()) + arr[i - 1];
        }

        long answer = Long.MIN_VALUE;
        for (int i = 0; i <= n - m; i++) {
            answer = Math.max(answer, arr[i + m] - arr[i]);
        }

        System.out.println(answer);
        br.close();
    }
}
