import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 받고, 단어에 들어간 글자와 빈도를 저장할 맵에 저장
        TreeMap<Character, Integer> map = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Text = br.readLine().toUpperCase();

        for(int i = 0; i < Text.length(); i++) {
            char now = Text.charAt(i);

            if(map.get(now) != null){
                map.replace(now, map.get(now)+1);
            }
            else {
                map.put(now, 1);
            }
        }

        int max = 0;
        char result = '?';
        
        // 최대값을 갖는 키를 찾고, 키가 여러개라면 ? 출력
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int now = entry.getValue();
            if (now > max) {
                max = now;
                result = entry.getKey();
            }
            else if (now == max) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}