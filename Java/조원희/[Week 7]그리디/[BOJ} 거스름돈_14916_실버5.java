import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int result = -1;
    private static boolean ok;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        Greedy(N, 0);
        System.out.println(result);
        br.close();
    }

    private static void Greedy(int N, int cnt){
        if(N == 0){
            result = cnt;
            ok = true;
            return;
        }
        if(N >= 5 && !ok)  Greedy(N - 5, cnt + 1);
        if(N >= 2 && !ok)  Greedy(N - 2, cnt + 1);
    }
}