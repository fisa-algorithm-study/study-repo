import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];

        int num = 0;
        int multi = 2;
        int cnt = 0;

        while(cnt != K){
            num += multi;

            if(num > N){
                for(int i = 2; i <= N; i++){
                    if(!visited[i]){ num = i;   multi = i;   break; }
                }
            }

            if(!visited[num]){
                visited[num] = true;
                cnt++;
            }
        }

        System.out.println(num);
        br.close();
    }
}