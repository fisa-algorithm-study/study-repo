import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        int lastNum = 0;

        for (int i = 2; i <= N; i++) {
            arr.add(i);
        }

        while(K>0){
            int p = arr.get(0);
            lastNum = arr.get(0);
            arr.remove(0);
            K--;
            if (K == 0) break;

            for(int i= 0 ; i<arr.size();i++){
                if(arr.get(i)%p==0) {
                    lastNum = arr.get(i);
                    arr.remove(i);
                    K--;
                    i--;
                    if (K == 0) break;
                }
            }
        }
        System.out.println(lastNum);

    }
}
