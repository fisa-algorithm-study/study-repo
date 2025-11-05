import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        // 배열의 길이 설정
        int rowLength = maps.length;
        int colLength = maps[0].length;

        // 2차원 배열을 벽으로 한 줄씩 패딩 > 탐색 시 코드 가독성 개선 (조건문 최소화)
        int[][] padded = new int[rowLength+2][colLength+2];             // 패딩된 maps 배열
        boolean[][] visited = new boolean[rowLength+2][colLength+2];    // visited
        Queue<int[]> queue = new LinkedList<>();                        // 탐색에 사용할 큐

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                padded[i + 1][j + 1] = maps[i][j];
            }
        }

        // 초기 위치 설정
        visited[1][1] = true;
        queue.add(new int[]{1, 1, 0}); // {x, y, depth}

        int[] dirX = {0, 0, +1, -1};
        int[] dirY = {+1, -1, 0, 0};

        while(!queue.isEmpty()) {
            int[] data = queue.poll();
            int x = data[0];
            int y = data[1];
            int depth = data[2] + 1;

            // 도착 위치라면 깊이를 리턴
            if (x == rowLength && y == colLength){
                return depth;
            } else {
                for(int i=0; i<4; i++) {
                    int newX = x + dirX[i];
                    int newY = y + dirY[i];

                    if(padded[newX][newY] == 1 && visited[newX][newY] == false){
                        queue.add(new int[]{newX, newY, depth});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        // 탐색실패
        return -1;
    }
}