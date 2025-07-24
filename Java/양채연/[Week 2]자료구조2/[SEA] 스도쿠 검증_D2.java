import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        // 테스트케이스 배열에 저장하기
        for (int t = 0; t < tc; t++) {
            // 테스트케이스마다 9*9배열 생성
            int arr[][] = new int[9][9];
            boolean bool = true;

            // 값 넣기
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로로 중복 확인하기
            for (int i = 0; i < 9; i++) {
                Set<Integer> row = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    row.add(arr[i][j]);
                }
                // set.size 개수가 9개가 아니면 중복O -> false
                if (row.size() != 9) {
                    bool = false;
                    break;
                }
            }

            // 세로로 중복 확인하기
            // 이미 false면 검사x
            if (bool) {
                for (int i = 0; i < 9; i++) {
                    Set<Integer> column = new HashSet<>();
                    for (int j = 0; j < 9; j++) {
                        column.add(arr[j][i]);
                    }
                    if (column.size() != 9) {
                        bool = false;
                        break;
                    }
                }
            }
            // 3*3 단위로 중복 확인
            // 이미 false면 검사x
            if (bool) {
                for (int row = 0; row < 9; row += 3) {
                    for (int col = 0; col < 9; col += 3) {
                        Set<Integer> square = new HashSet<>();
                        for (int i = row; i < row + 3; i++) {
                            for (int j = col; j < col + 3; j++) {
                                square.add(arr[i][j]);
                            }
                        }
                        if (square.size() != 9) {
                            bool = false;
                            break;
                        }
                        if (!bool)
                            break;
                    }
                }
            }
            int b = bool ? 1 : 0;
            bw.write("#" + t+1 + " " + b+"\n");
        }
        bw.flush();
        bw.close();
    }

}
