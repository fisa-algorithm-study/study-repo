import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];
        Arrays.fill(arr, 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++){
            arr[Integer.parseInt(st.nextToken())]--;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++){
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for(int i = 1; i <= N; i++){
            if(arr[i] == 0){
                if(arr[i - 1] == 2){
                    arr[i]++;
                    arr[i - 1]--;
                } else if(arr[i + 1] == 2){
                    arr[i]++;
                    arr[i + 1]--;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(arr[i] == 0) answer++;
        }
        System.out.println(answer);
        br.close();
    }
}