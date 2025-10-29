class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] sumBoard = new int[n+1][m+1];

        for (int i = 0; i < skill.length; i++) {
            int x1 = skill[i][1];
            int y1 = skill[i][2];
            int x2 = skill[i][3];
            int y2 = skill[i][4];
            int degree = skill[i][5];

            if (skill[i][0] == 1) degree = -degree; // 공격이면 음수 처리

            sumBoard[x1][y1] += degree;
            sumBoard[x2+1][y1] -= degree;
            sumBoard[x1][y2+1] -= degree;
            sumBoard[x2+1][y2+1] += degree;
        }

        // 세로 누적합
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n; j++) {
                sumBoard[j+1][i] += sumBoard[j][i];
            }
        }

        // 가로 누적합
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m; j++) {
                sumBoard[i][j+1] += sumBoard[i][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += sumBoard[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
