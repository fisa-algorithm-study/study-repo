import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        // 0부터 target까지 반복하며 가장 먼저 조건을 만족하는 숫자가 나오면 출력 후 break
        int tempValue;
        boolean flag = false;
        for (int i=0; i<target; i++){
            // i의 자릿수를 구하고
            ArrayList<Integer> digitList = makeDigitValues(i);
            tempValue = i;

            // 자릿수들을 더한 뒤
            for(int j : digitList){
                tempValue += j;
            }

            // 결과값이 target과 같다면 i 출력 후 break
            if(tempValue == target) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        // 만족하는 숫자가 없다면 0 출력
        if(flag == false)
            System.out.println(0);
    }

    // 자릿수 숫자들 구하기
    public static ArrayList<Integer> makeDigitValues(int target) {
        ArrayList<Integer> list = new ArrayList<>();

        int digits = 1;
        int tempValue = 0;      // 현재 자릿수 값

        while(true){
            if(target / digits == 0)
                break;
            tempValue = (target / digits) % 10;
            list.add(tempValue);
            digits *= 10;
        }

        return list;
    }
}
