import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = 0;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTraking(0, 0, N, S);
        System.out.println(answer);
        br.close();
    }

    private static void backTraking(int num, int add, int N, int S) {
        if(num != 0 && add == S) answer++;
        for(int i = num + 1; i <= N; i++) {
            backTraking(i, add + arr[i], N, S);
        }
    }
}