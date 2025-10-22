class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length+1][board[0].length+1];

        for(int[] info: skill){
            int r1=info[1];
            int c1=info[2];
            int r2=info[3];
            int c2=info[4];
            int degree = info[5];

            if(info[0]==1){
                sum[r1][c1]-=degree;
                sum[r1][c2+1]+=degree;
                sum[r2+1][c1]+=degree;
                sum[r2+1][c2+1]-=degree;

            }else{
                sum[r1][c1]+=degree;
                sum[r1][c2+1]-=degree;
                sum[r2+1][c1]-=degree;
                sum[r2+1][c2+1]+=degree;
            }
        }

        for(int i = 0 ;i <sum.length;i++){
            for(int j = 1 ; j < sum[i].length;j++){
                sum[i][j]+=sum[i][j-1];
            }
        }
        for(int i = 1 ;i <sum.length;i++){
            for(int j = 0 ; j < sum[i].length;j++){
                sum[i][j] += sum[i-1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}