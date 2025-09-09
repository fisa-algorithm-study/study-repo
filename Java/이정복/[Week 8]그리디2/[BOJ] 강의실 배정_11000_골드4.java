package week8.ClassRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // TreeMap을 사용해 강의 시작 시간 기준으로 오름차순 정렬하면서 추가
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.put(from, to);
        }

        // 강의실 수
        int classNum = 0;

        Map.Entry<Integer, Integer> entry;
        int index;
        while (!map.isEmpty()) {
            index = 0;

            while (true) {
                // 인덱스를 기준으로 강의 시작 시간이 가장 가까운 강의를 선택

                // 없다면 안쪽 루프가 종료되며, classNum++
                break;
            }
            classNum++;
            // 바깥쪽 루프는 map이 빌 때까지 반복
        }

        System.out.println(classNum);
    }
}
