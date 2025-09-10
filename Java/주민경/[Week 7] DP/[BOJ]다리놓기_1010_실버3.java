import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static int[][] inputArray;
    public static Long[][] memo;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	    int T = Integer.parseInt(br.readLine());
	    inputArray = new int[T][2];
	  
	    for (int i = 0; i < T; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        inputArray[i][0] = Integer.parseInt(st.nextToken());
	        inputArray[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    for (int i = 0; i < T; i++) {
	        int r = inputArray[i][0];
	        int n = inputArray[i][1];
	  
	        memo = new Long[n+1][r+1];
	        Long result = memoization(n, r);
	        System.out.println(result);
	    }
	}
	
	public static long memoization(int n, int r) {
	    if ((r == 0) || n == r) {
	        return 1L;
	    }
	    
	    if (memo[n][r] != null) {
	        return memo[n][r];
	    }
	    
	    memo[n][r] = memoization(n-1, r-1) + memoization(n-1, r);
	    return memo[n][r];
	}
}
