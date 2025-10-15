import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        int max = arr[M] - arr[0];
        for(int i = 1; i < N - M + 1; i++){
            int range = arr[i+M] - arr[i];
            if (max < range) max = range;
        }

        System.out.println(max);
        br.close();
    }
}

