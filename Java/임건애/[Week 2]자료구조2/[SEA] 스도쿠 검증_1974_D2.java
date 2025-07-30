import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            // 스도쿠 값 배열에 저장
            int[][] sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(line[j]);
                }
            }

            // flag - 겹치는 숫자가 없으면 1, 중복되면 0
            int flag = 1;

            // 가로줄 검사
            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(sudoku[i][j]);
                }

                if (set.size() != 9) {
                    flag = 0;
                    break;
                }
            }

            // 세로줄 검사
            for (int j = 0; j < 9; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 9; i++) {
                    set.add(sudoku[i][j]);
                }

                if (set.size() != 9) {
                    flag = 0;
                    break;
                }
            }

            // 3x3 검사
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    Set<Integer> set = new HashSet<>();

                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            set.add(sudoku[x][y]);
                        }
                    }

                    if (set.size() != 9) {
                        flag = 0;
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + flag);
        }
	}
}