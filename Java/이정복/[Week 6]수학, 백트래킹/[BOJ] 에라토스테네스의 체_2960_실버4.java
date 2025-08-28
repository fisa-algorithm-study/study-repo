//20m

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        TreeSet<Integer> list = new TreeSet<>();

        for(int i=2; i<=N; i++) {
            list.add(i);
        }

        int temp = 0;
        for(int i=0; i<N; i++) {
            temp = list.first();

            for(int j=1; temp*j <= N; j++) {
                if(list.contains(temp*j)) {
                    list.remove(temp * j);
                    count++;
                }

                if(count == K) {
                    System.out.println(temp*j);
                    return;
                }
            }
        }
    }
}
