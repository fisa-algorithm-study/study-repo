import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] DP;
    public static int[] arr;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            solve_front(i);
        }

        for(int i = 0; i < N; i++) {
            solve_back(i);
        }

        System.out.println(result);
        br.close();
    }

    public static void solve_front(int n) {
        DP[n] = 1;
        int num = arr[n];
        for(int i = 0; i < n; i++) {
            if (arr[i] < num && !(DP[i] < DP[n])) {
                DP[n]++;
            }
        }
    }

    public static void solve_back(int n) {
        int num = arr[n];
        for(int i = n-1; i >= 0; i--){
            if(arr[i] > num && DP[i] >= DP[n]) {
                DP[n] = DP[i] + 1;
            }
        }
        if(result < DP[n]) {
            result = DP[n];
        }
    }
}