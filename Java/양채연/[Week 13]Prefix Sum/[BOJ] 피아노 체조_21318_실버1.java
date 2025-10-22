import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int Q = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] prefix = new int[N + 1];

        // 누적된 실수 횟수를 prefix 배열에 저장
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i - 1] > arr[i])
                prefix[i] += prefix[i-1]+1;
            else
                prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(prefix[y]-prefix[x]).append("\n");
        }
        System.out.println(sb);
    }
}