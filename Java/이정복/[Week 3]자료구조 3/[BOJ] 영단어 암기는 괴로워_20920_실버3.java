import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 배열에 넣기
        int Number = Integer.parseInt(st.nextToken());
        int Length = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<Number; i++){
            String TempText = br.readLine();
            if(TempText.length() >= Length) {
                map.put(TempText, map.getOrDefault(TempText, 0) + 1);
            }
        }

        // comparator로 정렬 (우선순위 : 빈도수 - 길이 - 알파벳 순서)
        LinkedList<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue() - o1.getValue();
                } else if (o1.getKey().length() != o2.getKey().length()) {
                    return o2.getKey().length() - o1.getKey().length();
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        // StringBuilder append 사용
        for(Map.Entry<String, Integer> entry: entryList){
            sb.append(entry.getKey()).append("\n");
        }

        System.out.print(sb);
    }
}