import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        for (int s = 0 ; s < n; s++) {
            if (!visited[s+1]) {
                q.offer(s+1);
                while(!q.isEmpty()) {
                    int next = q.poll();
            
                    for (int i = 1; i <= n; i++) {
                        if (computers[next-1][i-1] == 1 && !visited[i]) {
                        q.offer(i);
                        visited[i] = true;
                        }   
                    }
                
                }
                answer++;
            }
    
        }
        
        
      
        return answer;
    }
}