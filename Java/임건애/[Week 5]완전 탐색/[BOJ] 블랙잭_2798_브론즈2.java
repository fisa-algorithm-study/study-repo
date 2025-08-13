import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		for (int a = 0; a < N - 2; a++) {
		    for (int b = a + 1; b < N - 1; b++) {
		        for (int c = b + 1; c < N; c++) {
		            int sum = arr[a] + arr[b] + arr[c];

                    if (sum > M) break;

                    if (sum > result) result = sum;
		        }
		    }
		}
		
		System.out.println(result);
	}
}