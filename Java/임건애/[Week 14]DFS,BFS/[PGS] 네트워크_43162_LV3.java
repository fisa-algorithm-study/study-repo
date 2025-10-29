class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, n, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void DFS(int start, int n, int[][] computers, boolean[] visited) {
        visited[start] = true;
        for (int next = 0; next < n; next++) {
            if (computers[start][next] == 1 && !visited[next]) {
                DFS(next, n, computers, visited);
            }
        }
    }
    
}