import javax.sound.midi.Soundbank;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] kayak = new int[n + 1];
        int cnt=0;
//        Arrays.fill(kayak, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            kayak[tmp]--;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            kayak[tmp]++;
        }

        for (int i = 1; i <= n; i++) {
            if (kayak[i] == -1) {
                if (i > 1 && kayak[i - 1] == 1) {
                    kayak[i - 1]--;
                    kayak[i]++;
                } else if (i<n && kayak[i + 1] == 1) {
                    kayak[i + 1]--;
                    kayak[i]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if(kayak[i]==-1)
                cnt++;
        }
        System.out.println(cnt);

    }

}