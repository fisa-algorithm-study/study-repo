import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        // 날짜별로 map에 넣기 (마감일 - 점수배열)
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i=0; i<length; i++){
            String[] tempText = br.readLine().split(" ");
            int[] tempints = {Integer.parseInt(tempText[0]), Integer.parseInt(tempText[1])};
            int key = tempints[0];
            int value = tempints[1];

            if(map.containsKey(tempints[0])){
                List<Integer> values = map.get(key);
                values.add(value);
            } else {
                map.put(key, new ArrayList<Integer>());
                map.get(key).add(value);
            }
        }

        // 마감일이 늦는 것부터 확인
        int Lastday = map.lastKey();
        int sum = 0;

        for(int today=Lastday; today>0; today--){
            // 최대값과 해당 값을 갖는 키값
            int now = 0;
            int index = -1;

            // 남은 과제 중에서 점수 최대값 선택 후 삭제
            for(int i = today; i<=Lastday; i++){
                if(map.containsKey(i)) {
                    ArrayList<Integer> list = map.get(i);
                    for (int score : list) {
                        if (score > now) {
                            now = score;
                            index = i;
                        }
                    }
                }
            }
            if(index != -1) {
                map.get(index).remove(map.get(index).indexOf(now));
                sum += now;
                if (map.get(index).isEmpty()) {
                    map.remove(index);
                }
            }
        }
        System.out.println(sum);
    }
}