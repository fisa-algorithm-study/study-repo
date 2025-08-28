// 10분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String query = br.readLine();

        // 이미 탐색한 문자열까지의 인덱스
        int greedyFlag = 0;
        
        // 포함된 문자열 개수
        int count = 0;

        // 문서나 검색어가 비어있다면 0 리턴
        if(document.isEmpty() || query.isEmpty())
            System.out.println(0);

        while (true) {
            // GreedyFlag를 증가시키며 검색을 수행
            greedyFlag = document.indexOf(query, greedyFlag);
            if(greedyFlag == -1)
                break;

            greedyFlag += query.length();

            count++;
        }

        System.out.println(count);
    }
}
