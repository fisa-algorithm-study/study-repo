import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열에 넣기
        int PokemonLength = Integer.parseInt(st.nextToken());
        int QuestionLength = Integer.parseInt(st.nextToken());
        
        // 탐색 시간을 줄이기 위해 도감번호-이름, 이름-도감번호 맵을 각각 만듭니다.
        HashMap<Integer, String> dictionaryWithIntKey = new HashMap<>();
        HashMap<String, Integer> dictionaryWithStrKey = new HashMap<>();
        for(int i = 1; i <= PokemonLength; i++){
            String tempString = br.readLine();
            dictionaryWithIntKey.put(i, tempString);
            dictionaryWithStrKey.put(tempString, i);
        }

        // 문제 수만큼 반복 시작
        for (int i = 0; i<QuestionLength; i++){
            String tempString = br.readLine();
            // int로 변환이 되는 입력이면 숫자로 탐색, exeption이 뜬다면 영어로 탐색
            try{
                int num = Integer.parseInt(tempString);
                System.out.println(dictionaryWithIntKey.get(num));
            } catch (NumberFormatException ex) {
                System.out.println(dictionaryWithStrKey.get(tempString));
            }
        }
    }
}