import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                int n = (minHeap.peek() == null) ? 0 : minHeap.poll();
                result.append(n);
                
                if (i != N - 1) {
                    result.append("\n");
                }
            } else {
                minHeap.add(x);
            }
            
        }
        
        System.out.println(result);
        
        
	}
}
