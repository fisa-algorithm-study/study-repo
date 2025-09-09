import java.util.*;
import java.io.*;

class Main
{
    public static long comb(int N, int M) {
        if (N > M - N) N = M - N;
        
        long result = 1;
        for (int i = 0; i < N; i++) {
            result = result * (M - i) / (i + 1);
        }
        
        return result;
    }
    
	  public static void main (String[] args) throws IOException
	  {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int[] N = new int[T];
        int[] M = new int[T];
        
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            N[i] = Integer.parseInt(st.nextToken());
            M[i] = Integer.parseInt(st.nextToken());
            
            System.out.println(comb(N[i], M[i]));
        }
        
        br.close();
	  }
}