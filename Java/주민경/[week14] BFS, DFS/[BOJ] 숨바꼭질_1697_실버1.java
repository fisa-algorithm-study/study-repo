import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt(); // 수빈이가 있는 위치
	    int K = sc.nextInt(); // 동생이 있는 위치 
	    
	    boolean[] visited = new boolean[100001];
	    Queue<int[]> queue = new LinkedList<>();
	    queue.offer(new int[]{N, 0});
	    
	    while (!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        int p = cur[0];
	        int count = cur[1];
	        
	        if (p == K) {
	            System.out.println(count);
	            break;
	        }
	        
	        for (int next: new int[]{p-1, p+1, 2*p}) {
	            if (next >= 0 && next <= 100000 && !visited[next]) {
	               visited[next] = true;
	               queue.offer(new int[]{next, count+1});
	            }
	        }
	    }
	}
}
