import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
     public static void main(String[] args) throws IOException {
         // Scanner보다 실행 시간이 빠른 BufferedReader 사용
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String Text = br.readLine();

         // 스도쿠 개수 입력받고 배열 생성
         int length = Integer.parseInt(Text);
         for(int freq_case = 0; freq_case<length; freq_case++) {
             //스도쿠 입력받기
             int[][] array = new int[9][9];
             for (int i = 0; i < 9; i++) {
                 String[] Tokens = br.readLine().split(" ");
                 for (int j = 0; j < 9; j++) {
                     array[i][j] = Integer.parseInt(Tokens[j]);
                 }
             }

             int complete = 1;
             // 가로 검사
             for (int i = 0; i < 9; i++) {
                 HashSet<Integer> set = new HashSet<>();
                 for (int j = 0; j < 9; j++) {
                     if (set.contains(array[i][j])) {
                         complete = 0;
                     }
                     set.add(array[i][j]);
                 }
             }

             // 세로 검사
             for (int i = 0; i < 9; i++) {
                 HashSet<Integer> set = new HashSet<>();
                 for (int j = 0; j < 9; j++) {
                     if (set.contains(array[j][i])) {
                         complete = 0;
                     }
                     set.add(array[j][i]);
                 }
             }

             // 9x9 검사
             for (int i = 0; i < 9; i += 3) {
                 for (int j = 0; j < 9; j += 3) {
                     HashSet<Integer> set = new HashSet<>();

                     //아래 for문은 최대 수행 횟수가 9회이기 때문에 O(n)으로 취급
                     for (int k = 0; k < 3; k++) {
                         for (int s = 0; s < 3; s++) {
                             if (set.contains(array[i + k][j + s])) {
                                 complete = 0;
                             }
                             set.add(array[i + k][j + s]);
                         }
                     }
                 }
             }

             System.out.printf("#%d %d\n", freq_case+1, complete);
         }
     }
}