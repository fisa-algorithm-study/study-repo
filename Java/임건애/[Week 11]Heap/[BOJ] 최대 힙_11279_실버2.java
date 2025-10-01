import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1,o2);
            }
        });
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                int n = (maxHeap.peek() == null) ? 0 : maxHeap.poll();
                result.append(n);
                
                if (i != N - 1) {
                    result.append("\n");
                }
            } else {
                maxHeap.add(x);
            }
            
        }
        
        System.out.println(result);
        
        
	}
}
