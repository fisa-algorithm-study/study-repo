import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 팀 수
        int S = Integer.parseInt(st.nextToken()); // 손상된 팀 수
        int R = Integer.parseInt(st.nextToken()); // 여분 카약 팀 수
        
        int[] kayak = new int[N];
        Arrays.fill(kayak, 1);

        // 손상 카약 --
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int broken = Integer.parseInt(st.nextToken());
            kayak[broken - 1]--;
        }

        // 여분 카약 ++
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int extra = Integer.parseInt(st.nextToken());
            kayak[extra - 1]++;
        }
        
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            if (kayak[i] == 0) {
                if (i - 1 >= 0 && kayak[i - 1] == 2) {  // 앞팀에서 빌리기
                    kayak[i - 1]--;
                } else if (i + 1 < N && kayak[i + 1] == 2) {    // 뒷팀에서 빌리기기
                    kayak[i + 1]--;
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
        
    }
    
}