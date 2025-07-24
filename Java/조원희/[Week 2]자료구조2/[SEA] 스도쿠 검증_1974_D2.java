import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tst = 1; tst <= 10; tst++) {
            int[][] arr = new int[9][9];

            StringTokenizer st;
            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(tst).append(" ").append(solution(arr)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int solution(int[][] arr) {
        HashSet<Integer> set;
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(set.contains(arr[i][j])) return 0;
                set.add(arr[i][j]);
            }
        }

        for(int j = 0; j < 9; j++) {
            set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if(set.contains(arr[i][j])) return 0;
                set.add(arr[i][j]);
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                set = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if(set.contains(arr[i][j])) return 0;
                        set.add(arr[i][j]);
                    }
                }
            }
        }

        return 1;
    }
}