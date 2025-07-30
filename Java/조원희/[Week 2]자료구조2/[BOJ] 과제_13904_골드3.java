import java.util.*;
import java.io.*;

class Node {
    int d;
    int w;

    public Node(int d, int w) {
        this.d = d;
        this.w = w;
    }
}

// 이 문제의 핵심은 마감일 기준으로 거꾸로 확인하는 것 (큰 것부터 작은 것)
// 일단 마감일 기준 가장 큰 것 부터 시작
// 마감일 기준으로 점수를 얻을 수 있는 날에 해당하는 과제 기준 가장 큰 점수 고르기
// 그렇다면 먼저 마감일 기준으로 정렬
// 그 마감일에 해당되는 과제를 모두 꺼내 과제 우선순위로 한번 더 정렬

public class Main {
    private static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N =  Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        StringTokenizer st;
        int end = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int d =  Integer.parseInt(st.nextToken());
            int w =  Integer.parseInt(st.nextToken());
            list.add(new Node(d, w));

            end = Math.max(end, d);
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.d == o2.d) {
                    return o2.w - o1.w;
                }
                return o2.d - o1.d;
            }
        });

        int answer = 0;
        for(int i = end; i > 0; i--) {
            answer += solution(i);
        }

        sb.append(answer);
        System.out.println(sb);
        br.close();
    }

    private static int solution(int current) {
        int index = -1, value = 0;

        for(int i = 0; i < list.size(); i++) {
            int d =  list.get(i).d;
            int w = list.get(i).w;

            if(current > d)   break; // 현재 남아 있는 마감 기한이 없다면

            if(w > value){
                value = w;
                index = i;
            }
        }

        if(index != -1) list.remove(index);
        return value;
    }
}