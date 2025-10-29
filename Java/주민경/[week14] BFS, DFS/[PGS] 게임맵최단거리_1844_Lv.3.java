import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] direction = {
            {1, 0},
            {-1, 0},
            {0, -1}, 
            {0, 1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});
        
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            
            if (next[0] == n-1 && next[1] == m-1) {
                answer = next[2] + 1;
                System.out.println(answer);
                break;
            }
            
            for (int i = 0; i < direction.length; i++) {
                int dx = direction[i][0] + next[0];
                int dy = direction[i][1] + next[1];
                int count = next[2];
                
                if (dx >= 0 && dy >= 0 && dx < n && dy < m && maps[dx][dy] == 1 && !visited[dx][dy]) {
                    queue.offer(new int[]{dx, dy, count+1});
                    visited[dx][dy] = true;
                    
                }
            }
        }
        return answer;
    }
}